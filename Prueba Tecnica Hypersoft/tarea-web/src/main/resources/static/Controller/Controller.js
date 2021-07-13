var controller =angular.module("Controller",[]);
controller.controller("LoginController",function($scope,$http){
        $scope.Usuario={};

        $scope.getUsuario=function(){
            var id=0;
          var usr = {
                Correo_Usr:$scope.Usuario.Correo,
                pass:$scope.Usuario.pass,
                Id_Usuario:id
            };

        $http.post("http://localhost:8080/Tareas-WEB/User",JSON.stringify(usr))
            .success(function(data) {
                if(data==true){
                    alert(data)
                    location.href ='//localhost:8080/ListaTareas.html';
                }else{
                    location.href ='//localhost:8080/index.html';
                    alert("Usuario o Contraseña Incorrecta");
                }
            })
            .error(function(err,status){
                alert(err,status)
            });
            
        }
    });

controller.controller("ListaTareasController",function($scope,$http){
    $scope.ListaTareas=[];
    $scope.NewTarea={};
    $scope.Modal=false;
    $scope.id_tr=0;

    $http.get("http://localhost:8080/Tareas-WEB/Tareas")
            .success(function(data) {
                $scope.ListaTareas=data;
                window.history.replaceState({},'Tareas-WEB','ListaTareas.html');
            })
            .error(function(err,status){
                alert(err,status)
            });

    $scope.CerrarSesion = function(){
        location.href ='//localhost:8080/index.html';
    }

    $scope.setModal = function(valor,id){
        $scope.Modal=$scope.Modal? false:true;
        if (valor) {
            if ($scope.Modal){
                var Modal=document.getElementById("id_modal");
                var Contenedor=document.getElementById("id_contenedor");
                document.getElementById("EncabezadoModal").textContent="Nueva Tarea";
                $scope.id_tr=id;
                Modal.style.opacity= 1;
                Contenedor.style.opacity= 1;
                Modal.style.visibility= "visible";
                Contenedor.style.visibility= "visible";
                
            }else{
                var Modal=document.getElementById("id_modal");
                var Contenedor=document.getElementById("id_contenedor");
                var txt_Descripcion=document.getElementById("txt_Descripcion");
                Modal.style.opacity=0;
                Modal.style.visibility= "hidden";
                Contenedor.style.opacity=0;
                Contenedor.style.visibility= "hidden";
                txt_Descripcion.value="";
            }
        }else{
            if ($scope.Modal){
                var Modal=document.getElementById("id_modal");
                var Contenedor=document.getElementById("id_contenedor");
                document.getElementById("EncabezadoModal").textContent="Editar Tarea";
                $scope.id_tr=id;
                Modal.style.opacity= 1;
                Contenedor.style.opacity= 1;
                Modal.style.visibility= "visible";
                Contenedor.style.visibility= "visible";
                
            }else{
                var Modal=document.getElementById("id_modal");
                var Contenedor=document.getElementById("id_contenedor");
                var txt_Descripcion=document.getElementById("txt_Descripcion");
                Modal.style.opacity=0;
                Modal.style.visibility= "hidden";
                Contenedor.style.opacity=0;
                Contenedor.style.visibility= "hidden";
                txt_Descripcion.value="";
            }
        } 
    }

    $scope.addPost = function(){
        var tr ={
            Tipo_Tr:$scope.NewTarea.Tipo_Tr,
            Descripcion_Tr:$scope.NewTarea.Descripcion_Tr,
            Prioridad_Tr: $scope.NewTarea.Prioridad_Tr,
            id_tr:$scope.id_tr
        };
        $http.post("http://localhost:8080/Tareas-WEB/Tareas",JSON.stringify(tr)).
        success(function(data){
            $scope.ListaTareas.push(data);
            $scope.NewTarea={};
            $scope.setModal();
            $http.get("http://localhost:8080/Tareas-WEB/Tareas")
            .success(function(data) {
                $scope.ListaTareas=data;
                $scope.id_tr=0;
            })
            .error(function(err,status){
                alert(err,status)
            });
        }).error(function(err){
            alert(err);
        });
    }

    $scope.Delete = function(id){
        $http.delete("http://localhost:8080/Tareas-WEB/Tareas/"+id.tr.id_tr).
        success(function(data){
            if(data==true){
                $http.get("http://localhost:8080/Tareas-WEB/Tareas")
            .success(function(data) {
                $scope.ListaTareas=data;
            })
            .error(function(err,status){
                alert(err,status)
            });
            }
        }).error(function(err){
            alert(err);
        });
    }

    $scope.EditarPosicion = function(accion,id){
        
        if (accion) {
            var pos = $scope.ListaTareas.findIndex(tr=> tr.id_tr ==id);
            if (pos-1!=-1) {
                var tar1 = $scope.ListaTareas[pos];
                var tar2 =$scope.ListaTareas[pos-1];
                $scope.ListaTareas[pos-1]=tar1;
                $scope.ListaTareas[pos]=tar2;
            }
        } else {
            var pos = $scope.ListaTareas.findIndex(tr=> tr.id_tr ==id);
            var tar1 = $scope.ListaTareas[pos];
            var tar2 =$scope.ListaTareas[pos+1];
            if (pos+1!=$scope.ListaTareas.length) {
                $scope.ListaTareas[pos]=tar2;
                $scope.ListaTareas[pos+1]=tar1;
            }
        }
    }
});
