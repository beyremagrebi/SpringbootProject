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

    <form>
        <fieldset disabled>
            <legend>  Demande Bourse Scolaire</legend>
            <pre>
nom : <input type="text" class="form-control" name="NomComplet" value="${demande.nomComplet}">cin: <input type="text" class="form-control" name="cin" value="${demande.cin}">email: <input type="email" class="form-control" name="email" value="${demande.email}">tel: <input type="text" class="form-control" value="22444555" name="numerotel" value="${demande.numerotel}">adresse: <input type="text" class="form-control" name="adresse" value="${demande.adresse}">
revenu : <input type="text" class="form-control" name="revenuAnnuel" value="${demande.revenuAnnuel}">
            </pre>
        </fieldset>
        <bttuon class="btn btn-success float-end m-2"><i class="fas fa-edit"></i></bttuon>
        <bttuon class="btn btn-danger float-end m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop" ><i class="fas fa-trash"></i></bttuon>
    </form>




    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Bourse Scolaore</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i></button>
                    <a href="supprimerDemande?id=${demande.id}" type="button" class="btn btn-danger"><i class="fas fa-trash"></i></a>
                </div>
            </div>
        </div>
    </div>
</div>


<br/>
<br/>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>