package com.andreyvolkov.sevcableapp.View.Fragment.Customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andreyvolkov.sevcableapp.R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class CustomerMap extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(this, "pk.eyJ1IjoiYWRzdGFyb3Zlcm92IiwiYSI6ImNqb2Jvc2x3NjBlaGEza2w3eDV5bDAyNXMifQ.muEIG0x9Z1sSDoYoV7o0gw");
        setContentView(R.layout.activity_customer_map);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                IconFactory iconFactory = IconFactory.getInstance(CustomerMap.this);
                // One way to add a marker view
                Icon security_icon = iconFactory.fromResource(R.drawable.security);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924125, 30.243321))
                        .title("Служба безопасности")
                        .snippet("Вход в порт")
                        .icon(security_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924798, 30.241476))
                        .title("Служба безопасности")
                        .snippet("Вход в порт")
                        .icon(security_icon)
                );
                Icon hotel_icon = iconFactory.fromResource(R.drawable.hostel);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.923996, 30.243439))
                        .title("Хостел")
                        .snippet("Круглосуточно")
                        .icon(hotel_icon)
                );
                Icon office_icon = iconFactory.fromResource(R.drawable.office);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924872, 30.241357))
                        .title("Офис команды Порта Севкабель")
                        .icon(office_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924270, 30.242302))
                        .title("\"Башня\"")
                        .snippet("Здание А")
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.923780, 30.241476))
                        .title("\"Кабельный цех\"")
                        .snippet("Здание Б")
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924879, 30.240886))
                        .title("\"УКТ\"")
                        .snippet("Здание Д")
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924879, 30.239384))
                        .title("\"НИИ\"")
                        .snippet("Здание Е")
                );

                Icon cafe_icon = iconFactory.fromResource(R.drawable.cafe);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924486, 30.242130))
                        .title("Кафе/фудкорт")
                        .icon(cafe_icon)
                );
                Icon coffe_icon = iconFactory.fromResource(R.drawable.coffe);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924615, 30.241841))
                        .title("Кофейня")
                        .icon(coffe_icon)
                );


                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924701, 30.241594))
                        .title("Кофейня")
                        .icon(coffe_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924540, 30.241337))
                        .title("Кофейня")
                        .icon(coffe_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924400, 30.241680))
                        .title("Кафе/фудкорт")
                        .icon(cafe_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924922, 30.23986))
                        .title("Кафе/фудкорт")
                        .icon(cafe_icon)
                );
                Icon shop_icon = iconFactory.fromResource(R.drawable.shop);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924486, 30.241476))
                        .title("Магазин")
                        .icon(shop_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924529, 30.241605))
                        .title("Магазин")
                        .icon(shop_icon)
                );
                Icon wc_icon = iconFactory.fromResource(R.drawable.wc);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924319, 30.241047))
                        .title("Туалет")
                        .icon(wc_icon)
                );
                Icon child_icon = iconFactory.fromResource(R.drawable.child);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924286, 30.241111))
                        .title("Комната матери и ребенка")
                        .icon(child_icon)
                );
                Icon sight_icon = iconFactory.fromResource(R.drawable.sight);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.923392, 30.241186))
                        .title("Панорамный вид")
                        .icon(sight_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.923818, 30.240360))
                        .title("Панорамный вид")
                        .icon(sight_icon)
                );


                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924567, 30.239030))
                        .title("Панорамный вид")
                        .icon(sight_icon)

                );

                Icon activity_icon = iconFactory.fromResource(R.drawable.activity);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924426, 30.240038))
                        .title("Площадка для проведения мероприятий")
                        .icon(activity_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924712, 30.240897))
                        .title("Площадка для проведения мероприятий")
                        .icon(activity_icon)
                );
                Icon info_icon = iconFactory.fromResource(R.drawable.info);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924620, 30.241197))
                        .title("Информационный стенд")
                        .icon(info_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924750, 30.240135))
                        .title("Информационный стенд")
                        .icon(info_icon)
                );
                Icon play_icon = iconFactory.fromResource(R.drawable.playing);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924637, 30.239159))
                        .title("Детская площадка")
                        .icon(play_icon)
                );

                Icon music_icon = iconFactory.fromResource(R.drawable.music);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.925154, 30.240907))
                        .title("Кино/концерты")
                        .icon(music_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924766, 30.239416))
                        .title("Кино/концерты")
                        .icon(music_icon)
                );
                Icon bar_icon = iconFactory.fromResource(R.drawable.bar);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.925002, 30.241121))
                        .title("Бар")
                        .icon(bar_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.924809, 30.239534))
                        .title("Бар")
                        .icon(bar_icon)
                );
                Icon beer_icon = iconFactory.fromResource(R.drawable.beer);
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.925326, 30.240575))
                        .title("Крафтовое пиво")
                        .icon(beer_icon)
                );
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(59.925003, 30.240103))
                        .title("Крафтовое пиво")
                        .icon(beer_icon)
                );
            }
        });
    }
}
