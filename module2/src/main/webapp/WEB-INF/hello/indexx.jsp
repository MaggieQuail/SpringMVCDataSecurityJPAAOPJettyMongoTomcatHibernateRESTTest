<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>AAAAAAAAAA</title>>
<head>
</head>

<%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>--%>
<%--<script type="text/javascript">--%>
<%--  var prefix = '/index';--%>

<%--  var RestPost = function() {--%>
<%--    $.ajax({--%>
<%--      type: 'POST',--%>
<%--      url:  prefix,--%>
<%--      dataType: 'json',--%>
<%--      async: true,--%>
<%--      success: function(result) {--%>
<%--        alert('Время: ' + result);--%>
<%--      },--%>
<%--      error: function(jqXHR, textStatus, errorThrown) {--%>
<%--        alert(jqXHR.status + ' ' + jqXHR.responseText);--%>
<%--      }--%>
<%--    });--%>
<%--  }--%>

<%--</script>--%>

<body>

<button type="button" onclick="RestPost()">Метод POST</button>
<form>
    <p><input name="login"></p>
    <p><input type="submit" onclick="RestPost()"></p>
</form>

</body>
</html>