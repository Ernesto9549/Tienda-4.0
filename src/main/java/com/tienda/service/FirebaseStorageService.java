package com.tienda.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    
    //Este metodo devuelve el ulr de la imagen 
  public String cargaImagen(MultipartFile archivoLocalCliente,String carpeta,Long id);  
  
   //El BuketName es el <id_del_proyecto> + ".appspot.com#
    final String BucketName = "techshop-ce741.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-ce741-firebase-adminsdk-119ow-2ccc835a25.json";
  
}
