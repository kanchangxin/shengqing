package cn.qtone.util.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import cn.qtone.util.tools.ExcelUtils;
import cn.qtone.util.tools.LoggerUtil;


/**
 * spring 自带返回excel文档接口
 * @author ygl
 *
 */
public class SpringExcelView extends AbstractExcelView {
	private Map<String, String> ExcleFieldToBeanFiledMap; // 模板和字段的映射MAP
	private List beanList; // 需要导出的bean

	private String[] template; // excel中导出的模板字段

	private String sheetName; // sheet 名字

	private String fileName; // 给用户下载的文件名

	private boolean needTitle; // 是否需要设置头

	private boolean needFoot; // 是否需要设置尾

	private String title; // 设置的头的标题
	
	private Object obannotation=null;//值转换实现类

	public Object getObannotation() {
		return obannotation;
	}

	public void setObannotation(Object obannotation) {
		this.obannotation = obannotation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, String> getExcleFieldToBeanFiledMap() {
		return ExcleFieldToBeanFiledMap;
	}

	public void setExcleFieldToBeanFiledMap(
			Map<String, String> excleFieldToBeanFiledMap) {
		ExcleFieldToBeanFiledMap = excleFieldToBeanFiledMap;
	}

	public List getBeanList() {
		return beanList;
	}

	public void setBeanList(List beanList) {
		this.beanList = beanList;
	}

	public String[] getTemplate() {
		return template;
	}

	public void setTemplate(String[] template) {
		this.template = template;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isNeedTitle() {
		return needTitle;
	}

	public void setNeedTitle(boolean needTitle) {
		this.needTitle = needTitle;
	}

	public boolean isNeedFoot() {
		return needFoot;
	}

	public void setNeedFoot(boolean needFoot) {
		this.needFoot = needFoot;
	}
/**
 * 
 * @param ExcleFieldToBeanFiledMap
 * @param beanList
 * @param template
 * @param sheetName
 * @param fileName
 */
	public SpringExcelView(Map<String, String> ExcleFieldToBeanFiledMap,
			List beanList, String[] template, String sheetName, String fileName) {
		this.ExcleFieldToBeanFiledMap = ExcleFieldToBeanFiledMap;
		this.beanList = beanList;
		this.template = template;
		this.sheetName = sheetName;
		this.fileName = fileName;
	}

	/**
	 * 添加了值转换实现类
	 * @param ExcleFieldToBeanFiledMap
	 * @param beanList
	 * @param template
	 * @param sheetName
	 * @param fileName
	 * @param obann
	 */
	public SpringExcelView(Map<String, String> ExcleFieldToBeanFiledMap,
			List beanList, String[] template, String sheetName, String fileName,Object obann) {
		this.ExcleFieldToBeanFiledMap = ExcleFieldToBeanFiledMap;
		this.beanList = beanList;
		this.template = template;
		this.sheetName = sheetName;
		this.fileName = fileName;
		this.obannotation=obann;
	}
	
	
	
	
	@Override
	protected void buildExcelDocument(Map arg0, HSSFWorkbook wb,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//判断是否ie浏览器
		boolean isIE=request.getHeader("user-agent").toString().toLowerCase().contains("msie");
		if(isIE){
			//设置导出格式，导出默认文件名和编码
	        String contentType = "application/octet-stream nd.ms-excel;charset=UTF-8";
	        response.setContentType(contentType);
	        response.setHeader("Content-disposition", "attachment; filename="
	                + java.net.URLEncoder.encode(fileName, "UTF-8"));
		}else{
			//中文乱码处理
	        String tempfilename=fileName;
	        response.setContentType("application/octet-stream");
	        tempfilename=new String(tempfilename.getBytes(System.getProperty("file.encoding")),"ISO-8859-1");
	        response.addHeader("Content-Disposition","attachment;filename=\""+tempfilename+"\"");
		}

        

		
		HSSFSheet s = wb.createSheet();
		wb.setSheetName(0, sheetName);

		int count = 0;

		if (needTitle) {
			// 生成表头
			HSSFRow templateRow0 = s.createRow(count);

			for (int j = 0; j < template.length; j++) {
				HSSFCell templateCell = templateRow0.createCell(j);
				templateCell.setCellValue("");
			}

			ExcelUtils.mergeRegion(s, count, (short) 0, count,
					(short) (template.length - 1), null);

			ExcelUtils.setValue(s, count, 0, title);

			count++;
			// 空一行
			count++;

		}

		/**
		 * 生成模板行
		 */

		HSSFRow templateRow = s.createRow(count);
		for (int j = 0; j < template.length; j++) {
			HSSFCell templateCell = templateRow.createCell(j);
			templateCell.setCellValue(template[j]);
		}
		count++;

		if(this.beanList!=null&&this.beanList.size()>0){
			if(this.beanList.get(0) instanceof Map)
				fillRowValueByMapList(s,count);
			else
			    fillRowValueByBeanList(s,count);
		} 
	}

	
	/**
	 * 从 List中的  Map 对象取值
	 * @param s
	 * @param count
	 * @throws Exception
	 */
	void fillRowValueByMapList(HSSFSheet s,int count) throws Exception{
		
		for (int i = 0; i < beanList.size(); i++) {
			
			HSSFRow row = s.createRow(i + count);
			Map<String,Object> mapValues =(Map<String,Object>)beanList.get(i);
			 
			 for(String keyName:mapValues.keySet()){
				 Object tempStr = mapValues.get(keyName);
				 tempStr=this.convertValue(tempStr,keyName);
				 for (short k = 0; k < template.length; k++) {
						if (ExcleFieldToBeanFiledMap.get(template[k]).equals(keyName)) {
							HSSFCell Cell = row.createCell(k);
							if(tempStr instanceof Long){
								Cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								Cell.setCellValue((Long)tempStr);
							}else if(tempStr instanceof Date){
								Cell.setCellType(Cell.CELL_TYPE_STRING);
								Cell.setCellValue((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format((Date)tempStr));
							}else if(tempStr!=null){
								Cell.setCellType(Cell.CELL_TYPE_STRING);
								Cell.setCellValue(tempStr.toString());
							}else{
								Cell.setCellType(Cell.CELL_TYPE_STRING);
								Cell.setCellValue("");
							}
							break;
						}
				}
				 
			 }
		}
	}
	
	
	/**
	 * 如果此对象 是 bean ，则用如下的方法进行处理
	 * @param s
	 * @param count
	 * @throws Exception
	 */
	void fillRowValueByBeanList(HSSFSheet s,int count) throws Exception{

		for (int i = 0; i < beanList.size(); i++) {

			HSSFRow row = s.createRow(i + count);

			Object object = beanList.get(i);
			//获取实体对象属性名称
			
			String className=object.getClass().getSimpleName();
			className=className.replaceFirst(className.substring(0, 1),className.substring(0, 1).toLowerCase()); //首字母转成小写
			String entryClassPath=className.replace("Info", "Entry");//转换成实体名称
			Field entryField=null;
			try{
				entryField=object.getClass().getDeclaredField(entryClassPath);
			}catch(Exception e){//无法找到对应的实体属性
				e.printStackTrace();
				LoggerUtil.info(entryClassPath);
				break;
			}
			entryField.setAccessible(true);
			Object entryObject=entryField.get(object);//获取实体属性
			
			Field[] fieldsP = entryObject.getClass().getSuperclass().getDeclaredFields();
			Field[] fieldsC = entryObject.getClass().getDeclaredFields();
			Field[] fields = getUnionFileds(fieldsP, fieldsC);

			for (int j = 0; j < fields.length; j++) {

				fields[j].setAccessible(true);
				Object tempStr = null;
				if (fields[j].get(entryObject) != null)
					tempStr = fields[j].get(entryObject);
				
				tempStr=this.convertValue(tempStr,fields[j]);
				
				for (short k = 0; k < template.length; k++) {
					if (ExcleFieldToBeanFiledMap.get(template[k]).equals(fields[j].getName())) {
						HSSFCell Cell = row.createCell(k);
						if(tempStr instanceof Long){
							Cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							Cell.setCellValue((Long)tempStr);
						}else if(tempStr instanceof Date){
							Cell.setCellType(Cell.CELL_TYPE_STRING);
							Cell.setCellValue((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format((Date)tempStr));
						}else if(tempStr!=null){
							Cell.setCellType(Cell.CELL_TYPE_STRING);
							Cell.setCellValue(tempStr.toString());
						}else{
							Cell.setCellType(Cell.CELL_TYPE_STRING);
							Cell.setCellValue("");
						}
						break;
					}
				}
			}
		}
	}
	
	
	
	
	/**
	 * 值转换
	 * @param value:需要转换的值
	 * @param para：需要转换的属性
	 * @return
	 */
	private Object convertValue(Object value,Field field) {
		return convertValue(value,field.getName());
	}
	
	
	/**
	 * 值转换
	 * @param value:需要转换的值
	 * @param fieldName：需要转换的属性
	 * @return
	 */
	private Object convertValue(Object value,String fieldName) {
		if(obannotation==null){
			return value;
		}
		Method[] methods=obannotation.getClass().getDeclaredMethods();//获取所有的方法
		try{
			for(Method method:methods){
				boolean hasAnnotation = method.isAnnotationPresent(ExportMethodAnnotation.class); 
				if (hasAnnotation) { 
					ExportMethodAnnotation annotation=method.getAnnotation(ExportMethodAnnotation.class);
					if(fieldName.equals(annotation.name())){//注解和字段名字相同
						return method.invoke(obannotation, value);
					}
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}
	
	
	

	/**
	 *具有继承结构的BEAN 合并子父类字段 
	 * @param t1
	 * @param t2
	 * @return
	 */
	private Field[] getUnionFileds(Field[] t1, Field[] t2) {

		Field[] temp = new Field[t1.length + t2.length];

		for (int i = 0; i < temp.length; i++) {

			if (i < t1.length)
				temp[i] = t1[i];

			else {

				boolean flag = false;

				for (int j = 0; j < t1.length; j++)

				{
					if (t1[j].getName().equals(
							t2[temp.length - i - 1].getName()))
						flag = true;
					break;

				}

				if (!flag)
					temp[i] = t2[temp.length - i - 1];
				else
					temp[i] = null;
			}

		}

		return temp;

	}
}
