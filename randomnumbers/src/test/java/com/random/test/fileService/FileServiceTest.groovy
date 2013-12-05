package com.random.test.fileService

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.random.file.FileService
import com.random.file.impl.FileServiceImpl
import com.random.randoms.generators.impl.LKM;
import com.random.randoms.service.GeneratorService;
import com.random.randoms.service.impl.GeneratorServiceImpl;

class FileServiceTest {
	
	def static String FILE_NAME = "file_worker_test.txt";
	def FileService fileService = new FileServiceImpl();
	def GeneratorService generatorService;
	
	@Before
	def void before() {
		this.generatorService = new GeneratorServiceImpl(new LKM());
	}
	
	@Test
	def void test() {
		def expectedInts = generatorService.generate(100000);
		fileService.writeInts(FILE_NAME, expectedInts);
		
		def actualInts = fileService.readInts(FILE_NAME);
		
		Assert.assertArrayEquals(expectedInts.toArray(), actualInts.toArray());
	}

}
