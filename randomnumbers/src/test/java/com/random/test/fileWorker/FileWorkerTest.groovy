package com.random.test.fileWorker

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.random.file.FileService
import com.random.file.impl.FileWorker2
import com.random.randoms.GeneratorService
import com.random.randoms.impl.GeneratorServiceImpl
import com.random.randoms.impl.LKM

class FileWorkerTest {
	
	def static String FILE_NAME = "file_worker_test.txt";
	def FileService fileService = new FileWorker2();
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
