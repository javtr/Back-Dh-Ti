window.addEventListener('load', function () {
    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del odontologo

   const formulario = document.querySelector('#update_odontologo_form');

   formulario.addEventListener('submit', function (event) {
        event.preventDefault();

       let odontologoId = document.querySelector('#odontologo_id_update').value;

        //creamos un JSON que tendrá los datos del odontologo
        //a diferencia de un odontologo nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo

       const formData = {

           id: document.querySelector('#odontologo_id_update').value,

           nombre: document.querySelector('#nombre-update').value,

           apellido: document.querySelector('#apellido-update').value,

           matricula: document.querySelector('#matricula-update').value,
       };
        //invocamos utilizando la función fetch la API odontologos con el método PUT que modificará
        //al odontologo que enviaremos en formato JSON
       const url = '/odontologos/actualizar';

       const settings = {

           method: 'PUT',

           headers: {

               'Content-Type': 'application/json',

           },

        body: JSON.stringify(formData)

       }

        fetch(url,settings)

        .then(response => response.json())

        location.reload()
   })

})


    //Es la funcion que se invoca cuando se hace click sobre el id de un odontologo del listado
    //se encarga de llenar el formulario con los datos del odontologo
    //que se desea modificar

function findBy(id) {

        const url = '/odontologos/buscar'+"/"+id;

        const settings = {

            method: 'GET'

        }

        fetch(url,settings)

        .then(response => response.json())

        .then(data => {

            let odontologo = data;

            document.querySelector('#odontologo_id_update').value = odontologo.id;

            document.querySelector('#nombre-update').value = odontologo.nombre;

            document.querySelector('#apellido-update').value = odontologo.apellido;

            document.querySelector('#matricula-update').value = odontologo.matricula;

            document.querySelector('#div_odontologo_updating').style.display = "block";

        }).catch(error => {

            alert("Error: " + error);

 })

}
