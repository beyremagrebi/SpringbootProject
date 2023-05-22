<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="windows-1256">
    <title>Bourse Scolaire</title>
    <script src="https://kit.fontawesome.com/b8e9726f83.js" crossorigin="anonymous"></script>
    <style>
        .x{
            width: 700px;
            height: 500px;
            margin-left: 20%;
            padding: 10px;
            box-shadow: 3px 3px 2px 3px rgba(0,0,0,.3);
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Projet</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Demandes
                    </a>
                    <ul class="dropdown-menu">

                        <li><a class="nav-link active" aria-current="page" href="bourseScolaire">BourseScolaire</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="listdetails">mes demandes</a>
                </li>

            </ul>
        </div>
    </div>
</nav>


<div class="card x">

    <div class="list-group p-3">
        <h4 class="mb-3">Mes Demandes</h4>
        <!--<p>${demandes[1].email}</p>-->
        <c:forEach items="${demandes}" var="demande">
        <a href="details?id=${demande.id}" class="list-group-item list-group-item-action mb-3" aria-current="true">
            <div class="d-flex w-100 justify-content-between">
                <div style="display: flex;align-items: center">
                    <h5 class="mb-1">Bourse Scolaire</h5>
                    <span class="badge text-bg-primary">${demande.nomComplet}</span>
                </div>



                <small class="btn btn-primary "><i class="fas fa-info-circle"></i></small >
            </div>
            <p class="mb-1"></p>
            <small>01-04-2023</small>
        </a>

        </c:forEach>



    </div>
</div>


<br/>
<br/>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>