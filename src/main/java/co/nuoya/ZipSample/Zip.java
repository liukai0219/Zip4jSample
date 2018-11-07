package co.nuoya.ZipSample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 * Hello world!
 *
 */
public class Zip 
{
    public static void main( String[] args )
    {
    	//zipTest1();
    	//zipTest2();
    	//zipTest3();
    	//zipTest4();
    	
    	try {
    		// 利用zip文件名初始化zipfile实例
    		// 当文件已存在,会往现有zip文件中添加,不存在则新建
    		ZipFile zipfile = new ZipFile("D:\\tmp\\CreateSplitZipFile.zip");
    		
    		ArrayList<File> filelst = new ArrayList<>();
    		filelst.add(new File("D:\\tmp\\file1.txt"));
    		filelst.add(new File("D:\\tmp\\file2.txt"));
    		filelst.add(new File("D:\\tmp\\file3.txt"));
    		filelst.add(new File("D:\\tmp\\mysql-connector-java-5.1.39.zip"));
    		
    		// 设置压缩所需参数
    		ZipParameters parameters = new ZipParameters();
    		
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
    		
    		/**
    		 * 压缩等级
    		 * 可选值为：
    		 * DEFLATE_LEVEL_FASTEST - 最低压缩率，但速度最快
			 * DEFLATE_LEVEL_FAST - 低压缩率，但速度较快
			 * DEFLATE_LEVEL_NORMAL - 正常
			 * DEFLATE_LEVEL_MAXIMUM - 高压缩率，但速度有所减慢
			 * DEFLATE_LEVEL_ULTRA - 最高压缩率，但速度最慢
    		 */
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
    		
    		zipfile.createZipFile(filelst, parameters, true, 65536);
    	}catch(ZipException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	
    	
    }
    
    /**
     * 分割压缩
     */
    public static void zipTest5() {
    	try {
    		// 利用zip文件名初始化zipfile实例
    		// 当文件已存在,会往现有zip文件中添加,不存在则新建
    		ZipFile zipfile = new ZipFile("D:\\tmp\\CreateSplitZipFile.zip");
    		
    		ArrayList<File> filelst = new ArrayList<>();
    		filelst.add(new File("D:\\tmp\\file1.txt"));
    		filelst.add(new File("D:\\tmp\\file2.txt"));
    		filelst.add(new File("D:\\tmp\\file3.txt"));
    		filelst.add(new File("D:\\tmp\\mysql-connector-java-5.1.39.zip"));
    		
    		// 设置压缩所需参数
    		ZipParameters parameters = new ZipParameters();
    		
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
    		
    		/**
    		 * 压缩等级
    		 * 可选值为：
    		 * DEFLATE_LEVEL_FASTEST - 最低压缩率，但速度最快
			 * DEFLATE_LEVEL_FAST - 低压缩率，但速度较快
			 * DEFLATE_LEVEL_NORMAL - 正常
			 * DEFLATE_LEVEL_MAXIMUM - 高压缩率，但速度有所减慢
			 * DEFLATE_LEVEL_ULTRA - 最高压缩率，但速度最慢
    		 */
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
    		
    		zipfile.createZipFile(filelst, parameters, true, 65536);
    	}catch(ZipException e) {
    		e.printStackTrace();
    	}
    }
    /**
     * 添加流
     */
    public static void zipTest4() {
    	InputStream is = null;
    	try {
    		ZipFile zipfile = new ZipFile("D:\\tmp\\stream1.zip");
    		// 设置压缩所需参数
    		ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
    		
			// 设置流的文件名
			parameters.setFileNameInZip("file.txt");
			// 想添加流必须把该项设为true
			parameters.setSourceExternalStream(true);
			
			is = new FileInputStream("D:\\tmp\\file1.txt");
			
			// Creates a new entry in the zip file and adds the content to the zip file
			zipfile.addStream(is, parameters);
			
    	}catch(ZipException e) {
    		e.printStackTrace();
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    /**
     * 文件夹压缩
     */
    public static void zipTest3() {
    	try {
    		ZipFile zipfile = new ZipFile("D:\\tmp\\folder.zip");
    		File  folder1 = new File("D:\\tmp\\folder1");
    		
    		// 设置压缩所需参数
    		ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
    		
    		zipfile.addFolder(folder1, parameters);
    	}catch(ZipException e) {
    		e.printStackTrace();
    	}
    }
    /**
     * 单个文件和多个文件的压缩
     */
    public static void zipTest1() {
    	try {
    		// 利用zip文件名初始化zipfile实例
    		// 当文件已存在,会往现有zip文件中添加,不存在则新建
    		ZipFile zipfile = new ZipFile("D:\\tmp\\Zipfile.zip");
    		
    		File file1 = new File("D:\\tmp\\file1.txt");
    		File file2 = new File("D:\\tmp\\file2.txt");
    		
    		ArrayList<File> filelst = new ArrayList<>();
    		filelst.add(new File("D:\\tmp\\file3.txt"));
    		filelst.add(new File("D:\\tmp\\file4.txt"));
    		
    		// 设置压缩所需参数
    		ZipParameters parameters = new ZipParameters();
    		
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
    		
    		/**
    		 * 压缩等级
    		 * 可选值为：
    		 * DEFLATE_LEVEL_FASTEST - 最低压缩率，但速度最快
			 * DEFLATE_LEVEL_FAST - 低压缩率，但速度较快
			 * DEFLATE_LEVEL_NORMAL - 正常
			 * DEFLATE_LEVEL_MAXIMUM - 高压缩率，但速度有所减慢
			 * DEFLATE_LEVEL_ULTRA - 最高压缩率，但速度最慢
    		 */
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
    		
    		// 可以多次添加
			// 可以添加单个文件，也可以添加文件list
    		zipfile.addFile(file1, parameters);
    		zipfile.addFile(file2, parameters);
    		
    		// 设置被添加到zip文件的文件夹名
    		// file3 file4会被放到test文件夹中
    		parameters.setRootFolderInZip("test/");
    		zipfile.addFiles(filelst, parameters);
    	}catch(ZipException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * 加密压缩
     */
    public static void zipTest2() {
    	try {
    		// 利用zip文件名初始化zipfile实例
    		// 当文件已存在,会往现有zip文件中添加,不存在则新建
    		ZipFile zipfile = new ZipFile("D:\\tmp\\Zipfile2.zip");
    		
    		File file1 = new File("D:\\tmp\\file1.txt");
    		File file2 = new File("D:\\tmp\\file2.txt");
    		
    		ArrayList<File> filelst = new ArrayList<>();
    		filelst.add(new File("D:\\tmp\\file3.txt"));
    		filelst.add(new File("D:\\tmp\\file4.txt"));
    		
    		// 设置压缩所需参数
    		ZipParameters parameters = new ZipParameters();
    		
    		/**
    		 * 压缩方式
    		 * COMP_STORE
    		 * COMP_DEFLATE
    		 * COMP_AES_ENC 不可用
    		 */
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
    		
    		/**
    		 * 压缩等级
    		 * 可选值为：
    		 * DEFLATE_LEVEL_FASTEST - 最低压缩率，但速度最快
			 * DEFLATE_LEVEL_FAST - 低压缩率，但速度较快
			 * DEFLATE_LEVEL_NORMAL - 正常
			 * DEFLATE_LEVEL_MAXIMUM - 高压缩率，但速度有所减慢
			 * DEFLATE_LEVEL_ULTRA - 最高压缩率，但速度最慢
    		 */
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
			
			// 设置加密flg为true
			// 如果为false，加密设置会被忽略
			parameters.setEncryptFiles(true);
			
			/**
			 * 设置加密方式
			 * ENC_METHOD_STANDARD 标准
			 * ENC_METHOD_AES      AES
			 * ENC_NO_ENCRYPTION   当EncryptFiles为true时，只能为ENC_METHOD_STANDARD或ENC_METHOD_AES
			 */
			parameters.setEncryptionMethod(Zip4jConstants.ENC_NO_ENCRYPTION);
			
			/**
			 * 设置AES KEY长度
			 * AES_STRENGTH_128 - 加密+解密
			 * AES_STRENGTH_192 - 仅能解密
			 * AES_STRENGTH_256 - 加密+解密
			 * Key strength 192 不能用来加密，但是如果已经存在192的，zip4j提供解密
			 */
			parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
			
			// 密码
			parameters.setPassword("123456");
			
    		// 可以多次添加
			// 可以添加单个文件，也可以添加文件list
    		zipfile.addFile(file1, parameters);
    		zipfile.addFile(file2, parameters);
    		
    		// 设置被添加到zip文件的文件夹名
    		// file3 file4会被放到test文件夹中
    		parameters.setRootFolderInZip("test/");
    		zipfile.addFiles(filelst, parameters);
    	}catch(ZipException e) {
    		e.printStackTrace();
    	}
    }
    
}
