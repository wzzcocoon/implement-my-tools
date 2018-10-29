package cn.wzz.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

import lombok.Data;

/**
 * @ClassName: NcResultDto
 * @Description: nc返回报文Xml to bean
 * @author wzz
 * @date 2018年1月18日 上午8:40:25
 */

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ufinterface")
public class NcResultDto {
	// root element attributes start
	private String account;
	@XmlElement(name = "billtype")
	private String billType;
	@XmlElement(name = "filename")
	private String fileName;
	@XmlElement(name = "isexchange")
	private String isExchange;
	private String receiver;
	private String replace;
	@XmlElement(name = "roottag")
	private String rootTag;
	private String sender;
	private String successful;
	// root element attributes end
	@XmlElement(name = "sendresult")
	private NcResult ncResult;

	@Data
	public static class NcResult {
		private String billpk;
		private String bdocid;
		private String filename;
		private String resultcode;
		private String resultdescription;
		private String content;
		@XmlElementWrapper(name = "invaliddoc")
		@XmlElement(name = "docitem")
		private List<DocResult> docResult;

		@XmlTransient
		public List<DocResult> getDocResult() {
			return docResult;
		}

		public void setDocResult(List<DocResult> docResult) {
			this.docResult = docResult;
		}

	}

	public static class DocResult {
		@XmlValue
		private String docitem;

		@XmlAttribute
		private String name;

		@XmlTransient
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@XmlTransient
		public String getDocitem() {
			return docitem;
		}

		public void setDocitem(String docitem) {
			this.docitem = docitem;
		}

	}

}
