function deleteeeBy(id)
{
          //con fetch invocamos a la API de odontologos con el mÃ©todo DELETE
          //pasandole el id en la URL
             console.log("llega");

          const url = 'localhost:8080/odontologo/borrar/'+ id;

          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => response.json())

          //borrar la fila del odontologo eliminado
          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();

}