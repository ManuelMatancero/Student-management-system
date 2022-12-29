<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col">

                        <h1 class="mt-10">Listado de Alumnos</h1>
                        <br>
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Agregar
                        </button>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellido</th>
                                    <th scope="col">Direccion</th>
                                    <th scope="col">Pais</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${alumnos}" var="alumno">
                                    <tr>
                                        <td>${alumno.idAlumno}</td>
                                        <td>${alumno.nombre}</td>
                                        <td>${alumno.apellido}</td>
                                        <td>${alumno.domicilio.noCalle} ${alumno.domicilio.calle}</td>
                                        <td>${alumno.domicilio.pais}</td>
                                        <td><a href="${pageContext.request.contextPath}/alumnoControlador?accion=modificar&idAlumno=${alumno.idAlumno}" class="btn btn-warning">Editar</a>
                                            <a href="${pageContext.request.contextPath}/alumnoControlador?accion=eliminar&idAlumno=${alumno.idAlumno}" class="btn btn-danger">Eliminar</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <form action="${pageContext.request.contextPath}/alumnoControlador?accion=agregar"
                              method="POST" class="row g-2" >
                           
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre</label>
                                <input type="text" name="nombre"   class="form-control" id="nombre" placeholder="Nombre">
                            </div>
                            <div class="mb-3">
                                <label for="apellido" class="form-label">Apellido</label>
                                <input type="text"  name="apellido" class="form-control" id="apellido" placeholder="Apellido">
                            </div>
                            <br>
                            
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" id="email" placeholder="example@mail.com">
                            </div>
                            <div class="mb-3">
                                <label for="telefono" class="form-label">Telefono</label>
                                <input type="text" name="telefono" class="form-control" id="telefono" placeholder="000-000-0000">
                            </div>
                            <br>
                            
                            <div class="mb-3">
                                <label for="noCalle" class="form-label">No. Calle</label>
                                <input type="text" name="noCalle" class="form-control" id="noCalle" placeholder="#">
                            </div>
                            <div class="mb-3">
                                <label for="calle" class="form-label">Calle</label>
                                <input type="text" name="calle" class="form-control" id="calle" placeholder="general fl.">
                            </div>
                            <div class="mb-3">
                                <label for="pais" class="form-label">Pais</label>
                                <input type="text" name="pais" class="form-control" id="pais" placeholder="RepDom">
                            </div>

                            <button type="submit" class="btn btn-primary mb-3">Agregar Alumno</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                    </div>

                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
