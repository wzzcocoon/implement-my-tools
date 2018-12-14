package cn.wzz.test.compareBean;

public class Stu {
	
	/**
	 * 数据ID
	 */
	@CommentsAnnotation(comment = "数据ID")
	private String id;
	
	/**
	 * @Description:姓名
	 */
	@Deprecated
	@CommentsAnnotation(comment = "姓名")
	private String name;
	
	/**
	 * 年龄
	 */
	@CommentsAnnotation(comment = "年龄")
	private String age;
	
	public Stu() {
		super();
	}
	public Stu(String id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	/**
	 * 设置年龄
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}
	
}
