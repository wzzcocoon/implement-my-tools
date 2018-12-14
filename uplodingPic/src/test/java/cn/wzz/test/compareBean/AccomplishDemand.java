package cn.wzz.test.compareBean;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 比较两个对象属性值变化情况
 * 将字段属性 转换成中文名 
 * 返回一个Entity集合(改变的表名、字段属性、字段备注名称、旧值、新值、创建时间、创建人、更新时间、更新人、备注)
 */
public class AccomplishDemand {

    public List<ClientChangeEntity> contrastObj(Object oldBean, Object newBean) throws Exception{
    	List<ClientChangeEntity> reList = new ArrayList<ClientChangeEntity>();
    	Class clazz = oldBean.getClass();
    	Field[] fields = oldBean.getClass().getDeclaredFields();
    	for (Field field : fields) {
    		if("serialVersionUID".equals(field.getName())){
    			continue;
    		}
    		PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
    		Method getMethod = pd.getReadMethod();
    		Object o1 = getMethod.invoke(oldBean);
    		Object o2 = getMethod.invoke(newBean);
    		if(o1==null || o2 == null){
    			continue;
    		}
    		if (!o1.toString().equals(o2.toString())) {
    			ClientChangeEntity cc = new ClientChangeEntity();
    			// 获取自定义注解
    			Annotation annotation = field.getAnnotation(CommentsAnnotation.class);
    			// 有该类型的注解存在
    			if (annotation != null) {
    				CommentsAnnotation xmlElement = (CommentsAnnotation) annotation;
					//sb.append(comment).append(":").append(o1).append(" TO ").append(o2);
					cc.setColumnName(field.getName());
					cc.setComments(xmlElement.comment());
					cc.setOldVal(o1.toString());
					cc.setNewVal(o2.toString());
					cc.setCreateDate(new Date());
					reList.add(cc);
    			}
    		} 
    	}
        return reList;
    }
}
