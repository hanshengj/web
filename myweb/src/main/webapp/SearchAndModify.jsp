<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%--<%@page import="toolBean.db.AccessUserFromDB"%>--%>
<%@ page import="xpu.dao.UserinfoDAO" %>
<%@ page import="xpu.vo.UserinfoVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
    String username=request.getParameter("queryName");
    UserinfoVO user=new UserinfoVO();
    if(username!=null&&username!="")
    {
        UserinfoDAO userDAO=new UserinfoDAO();
        UserinfoVO temp=userDAO.searchByUsername(username);
        if(temp==null)
        {
            System.out.println("�û��������ڣ�");
        }
        else
            user=temp;//��ֹuserΪnull���������ĵ�user.getUsername()�����쳣
    }
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>��ѯ���޸��û�</title>
</head>

<body>
<div align="center">
    <form name="query" method="post" action="">
        <font face="����" size="6"><strong>��ѯ���޸��û�</strong></font><br/><hr/><br/>
        �����ѯ���û�����<input name="queryName" type="text"/><input type="submit" name="query" value="��ѯ�û�" /><br/><br/><hr/><br/>
    </form>

    <form name="modify" method="post" action="ModifyUser">
        �û�����
        <input name="modfyName" type="text" value="<%=user.getUsername()%>" readonly="readonly" />
        <br/><br/>
        ��&nbsp;&nbsp;�룺
        <input name="password" type="text" value="<%=user.getPassword()%>"/>
        <br /><br />
        <input type="submit" name="modify" value="�޸��û�" />
    </form>
    <hr/>
    <a href="DeleteUser.jsp">ɾ���û�</a><br/>
    <a href="AddUser.jsp">����û�</a><br/>
</div>
</body>
</html>
