<%@ page contentType="text/html; charset=UTF-8" language="java" %><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /><title>Untitled Document</title></head><body><form action="/apacheuploadservlet" method="post" enctype="multipart/form-data">op<input type="text" name="op" value="0" /><br/>title<input type="text" name="title" value="test title中文測試許成功"/><br/>txtcontent<input type="text" name="txtcontent" value="test content<b>中文測試許成功</b>"/><br/>quality<br/><input type="text" name="quality" value="0"/><br/>userclass<input type="text" name="userclass" value="0"/><br/>readgroup<input type="text" name="readgroup" value="0"/><br/>referergroup<input type="text" name="referergroup" value="0"/><br/>key<input type="text" name="userclass" value="0"/><br/>file<input type="file" name="file1"/><br/>file2<input type="file" name="file2"/><input type="submit"/></form></body></html>