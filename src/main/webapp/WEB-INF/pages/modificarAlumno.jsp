<%-- 
    Document   : modificarAlumno
    Created on : Dec 21, 2022, 11:54:25 PM
    Author     : manue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Alumno</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Modificar Alumno</h1>
                    <br>
                      <form action="${pageContext.request.contextPath}/alumnoControlador?accion=editar&idAlumno=${idAlumno}"
                              method="POST" class="row g-2" >
                           
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre</label>
                                <input type="text" name="nombre"   class="form-control" id="nombre" value="${nombre}">
                            </div>
                            <div class="mb-3">
                                <label for="apellido" class="form-label">Apellido</label>
                                <input type="text"  name="apellido" class="form-control" id="apellido" value="${apellido}">
                            </div>
                            <br>
                            
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" id="email" value="${email}">
                            </div>
                            <div class="mb-3">
                                <label for="telefono" class="form-label">Telefono</label>
                                <input type="text" name="telefono" class="form-control" id="telefono" value="${telefono}">
                            </div>
                            <br>
                            
                            <div class="mb-3">
                                <label for="noCalle" class="form-label">No. Calle</label>
                                <input type="text" name="noCalle" class="form-control" id="noCalle" value="${noCalle}">
                            </div>
                            <div class="mb-3">
                                <label for="calle" class="form-label">Calle</label>
                                <input type="text" name="calle" class="form-control" id="calle" value="${calle}">
                            </div>
                            <div class="mb-3">
                                <label for="pais" class="form-label">Pais</label>
                                <input type="text" name="pais" class="form-control" id="pais" value="${pais}">
                            </div>

                            <button type="submit" class="btn btn-primary mb-3">Modificar Alumno</button>
                            <a href="/WEB-INF/pages/listaAlumnos.jsp" class="btn btn-danger">Cancelar</a>
                        </form>
                </div>
            </div>
        </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>     
    </body>
</html>
