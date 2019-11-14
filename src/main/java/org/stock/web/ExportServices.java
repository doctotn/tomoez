package org.stock.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export")
public class ExportServices {

	@Autowired
	ExportData exportDate;
	
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value="/excel",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> export() throws IOException {
		String fileName="fiel.xls";
		List<ExportDto> content = mockContent();
		byte[] data = exportDate.exportContent(content);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+fileName)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
				.header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS)
				.header("fileName",fileName)
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(data.length)
				.body(data); 
	}


	private List<ExportDto> mockContent() {
		List<ExportDto> list = new ArrayList<ExportDto>();
		ExportDto export = new ExportDto();
		export.setBusinessGroup("Business");
		export.setCounterPartyName("Name");
		List<String> coverage = new ArrayList<>();
		export.setCoverage(coverage);
		list.add(export);
		return list;
	}
}
