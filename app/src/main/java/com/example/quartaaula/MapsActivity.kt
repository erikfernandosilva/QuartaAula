package com.example.quartaaula

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val LOCATION_PERMISSION_REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    // checar a permissao do usuario, senao o programa solicita a permissao
    private fun getLocationAccess(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mMap.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST)
        }
    }

    // fazendo a confirmacao de permissao para poder usar, caso nao seja aceito pelo usuario exibe toast e fecha o programa
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == LOCATION_PERMISSION_REQUEST){
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)){
                mMap.isMyLocationEnabled = true
            } else {
                Toast.makeText(this, "O usuário não deu permissão", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    // exibicao do mapa
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // mostrar a localizacao atual do usuario
        getLocationAccess()

        // colocado um marcador em Alegrete e permitido mover a camera
        /**val alegrete = LatLng(-29.7848, -55.7757)
        mMap.setMinZoomPreference(15.0f)
        mMap.addMarker(MarkerOptions().position(alegrete).title("Baita Chão!"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(alegrete))*/
    }
}