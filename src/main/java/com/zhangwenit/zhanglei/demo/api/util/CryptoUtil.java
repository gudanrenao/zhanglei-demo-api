package com.zhangwenit.zhanglei.demo.api.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;


/**
 * 加密工具类
 *
 * <pre>
 * AES支持128/192/256,取决于密钥长度(与位数对应)
 * DES密钥长度8字节
 * 3DES密钥长度24字节
 *
 * 采用CBC 需指定初始向量IV，长度与分组大小相同
 * DES为8字节；AES为16字节
 *
 * </pre>
 */
public class CryptoUtil {

    static {
        // add bouncycastle support for md4 etc..
        Security.addProvider(new BouncyCastleProvider());
    }

    public static enum CryptType {
        DES_ECB_PKCS5("DES/ECB/PKCS5Padding"),
        DES_CBC_PKCS5("DES/CBC/PKCS5Padding", 8),
        DESede_ECB_PKCS5("DESede/ECB/PKCS5Padding"),
        DESede_CBC_PKCS5("DESede/CBC/PKCS5Padding", 8),
        AES_ECB_PKCS5("AES/ECB/PKCS5Padding", 16),
        AES_CBC_PKCS5("AES/CBC/PKCS5Padding", 16),//AES支持128/192/256
        AES_CBC_PKCS7("AES/CBC/PKCS7Padding", 16);
        public final String algorithm;
        public final String keyAlg;
        public final int ivlen;

        private CryptType(String algorithm, int ivlen) {
            this.algorithm = algorithm;
            this.keyAlg = this.algorithm.substring(0, this.algorithm.indexOf('/'));
            this.ivlen = ivlen;
        }

        private CryptType(String algorithm) {
            this(algorithm, 0);
        }

        @Override
        public String toString() {
            return this.algorithm;
        }
    }

    /**
     * generate default ivparam for type
     *
     * @return
     */
    public static byte[] generateDefaultIv(CryptType type) {
        byte[] iv = new byte[type.ivlen];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = 0x01;
        }
        return iv;
    }

    /**
     * Encrypt the value with the encryption standard.
     *
     * <pre>
     * key must have the corresponding length.
     *
     * if use cbc mode which need iv param, the iv must not be null,
     * and iv data length is 16 for aes, 8 for des
     *
     * </pre>
     *
     * @param value
     * @param key
     * @param iv
     * @return
     */
    public static byte[] encrypt(byte[] value, byte[] key, byte[] iv, CryptType type) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, type.keyAlg);
            Cipher cipher = Cipher.getInstance(type.algorithm);
            IvParameterSpec ivparamSpec = null;
            if (iv != null) {
                ivparamSpec = new IvParameterSpec(iv);
            }
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivparamSpec);
            return cipher.doFinal(value);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Decrypt the value with the encryption standard.
     *
     * <pre>
     * key must have the corresponding length.
     *
     * if use cbc mode which need iv param, the iv must not be null,
     * and iv data length is 16 for aes, 8 for des
     *
     * </pre>
     *
     * @param value
     * @param key
     * @param iv
     * @param type
     * @return
     */
    public static byte[] decrypt(byte[] value, byte[] key, byte[] iv, CryptType type) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, type.keyAlg);
            Cipher cipher = Cipher.getInstance(type.algorithm);
            IvParameterSpec ivparamSpec = null;
            if (iv != null) {
                ivparamSpec = new IvParameterSpec(iv);
            }
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivparamSpec);
            return cipher.doFinal(value);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    /**
     * AES解密
     *
     * @param dataByte      //密文，被加密的数据
     * @param keyByte      //秘钥
     * @param ivByte       //偏移量
     * @param encodingFormat //解密后的结果需要进行的编码
     * @return
     * @throws Exception
     */
    public static String decrypt(byte[] dataByte, byte[] keyByte, byte[] ivByte, String encodingFormat) throws Exception {
//    initialize();


        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");

            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");

            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));

            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化

            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, encodingFormat);
                return result;
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
