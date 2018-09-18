package com.customs.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZxingCodeUtil {

    public static void main(String[] args) throws FileNotFoundException {
	File file = new File("d:/test.png");
	FileOutputStream outStream = new FileOutputStream(file);
	generateZxingCodeToStream("少小离家胖了归，乡音未改肉成堆。儿童相见不相识，介位胖子你是谁？", 300, 300, outStream, "jpg");
    }

    /**
     * 生成二维码
     * 
     * @param content   二维码内容
     * @param width     宽度
     * @param height    高度
     * @param outStream 输出流
     * @param format    格式，png,jpg,bmp等
     * @return
     */
    public static boolean generateZxingCodeToStream(String content, int width, int height, OutputStream outStream,
	    String format) {
	boolean flag = false;
	try {
	    // 定义二维码参数
	    Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
	    // 字符集
	    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
	    // 纠错级别
	    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
	    // 边距
	    hints.put(EncodeHintType.MARGIN, 2);
	    BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
	    MatrixToImageWriter.writeToStream(bitMatrix, format, outStream);
	    flag = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return flag;
    }

    /**
     * 读取二维码
     * 
     * @param input 二维码输入流
     * @return
     */
    public static Result readZxingCode(InputStream input) {
	Result result = null;
	try {
	    BufferedImage image = ImageIO.read(input);
	    BufferedImageLuminanceSource imageSource = new BufferedImageLuminanceSource(image);
	    HybridBinarizer hybridBinarizer = new HybridBinarizer(imageSource);
	    BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
	    MultiFormatReader mfr = new MultiFormatReader();
	    Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
	    hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
	    result = mfr.decode(binaryBitmap, hints);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return result;
    }
}
