<%-- 
    Document   : editacc
    Created on : Oct 24, 2023, 6:25:58 PM
    Author     : tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>
    <body>
        <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editaccount" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">edit account </h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${ac.id}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>user</label>
                                    <input value="${ac.user}" name="user" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>pass</label>
                                    <input value="${ac.pass}" name="pass" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>isAdmin</label>
                                    <!--<input value="${ac.isAdmin}" name="isAdmin" type="text" class="form-control" required>-->
                                    <td><input name="isAdmin" type="radio" value="0" (${ac.isAdmin}==0) ? "checked" : ""  class="form-control" required>no &nbsp</td>
                                <td><input name="isAdmin" type="radio" value="1" (${ac.isAdmin}==1)? "" : "checked" class="form-control" required>yes &nbsp</td>

                                </div>                                
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
    </body>
</html>
