package cn.wzz.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * @ClassName: XmlUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangzz
 * @date 2018年1月17日 下午2:11:27
 */
public class XmlUtils {

	public static <T> String marshal(T bean) throws Exception {
		Marshaller marshaller = JAXBContext.newInstance(bean.getClass()).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		StringWriter sw = new StringWriter();
		marshaller.marshal(bean, sw);
		return sw.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(T t, String xml) throws Exception {
		Unmarshaller unmarshaller = JAXBContext.newInstance(t.getClass()).createUnmarshaller();
		return (T) unmarshaller.unmarshal(new StringReader(xml));
	}

	public static void main(String[] args) throws Exception {
//		Test t = new Test();
//		t.setAge("30");
//		t.setName("张三");
//		String s = marshal(t);
//		System.out.println(s);
//		Test te = unmarshal(t, s);
//		System.out.println(te.getName());
//		String str = "<?xml version=\"1.0\" encoding='UTF-8'?><ufinterface billtype=\"supplier\" filename=\"supplierd267c001.xml\" isexchange=\"Y\" replace=\"Y\" roottag=\"sendresult\" sender=\"001\" successful=\"N\"><sendresult><billpk></billpk><bdocid>16102dd26b300000000000supplier0</bdocid><filename>supplierd267c001.xml</filename><resultcode>-99999</resultcode><resultdescription>单据  16102dd26b300000000000supplier0  开始处理...单据  16102dd26b300000000000supplier0  处理错误:业务插件处理错误:插件类=nc.bs.bd.pfxx.plugin.SupplierPfxxPlugin,异常信息:下列字段值已存在，不允许重复，请检查：[客商编码：D000033]</resultdescription><content></content><invaliddoc><docitem name=\"组织_集团\">1</docitem><docitem name=\"银行档案\">555</docitem></invaliddoc></sendresult></ufinterface>";
//		NcResultDto dto = unmarshal(new NcResultDto(), str);
//		System.out.println(dto.getNcResult().getResultcode());
//		System.out.println(dto.getNcResult().getResultdescription());
//		System.out.println(dto.getNcResult().getDocResult().getDocitem().size());
//		System.out.println(dto.getNcResult().getDocResult().getDocitem().get(0));
//		System.out.println(marshal(dto));

	}
}
