package com.example.neesrine.quakereport;

        import  android.util.Log ;

        import com.example.neesrine.myapplication.Earthquake;

        import  org.json.JSONArray ;
        import  org.json.JSONException ;
        import  org.json.JSONObject ;

        import java.text.SimpleDateFormat;
        import  java.util.ArrayList ;
        import java.util.Date;


public  final class QueryUtils {

        /** Exemple de réponse JSON pour une requête USGS **/

        private static final  String SAMPLE_JSON_RESPONSE = "{\" type \": \" FeatureCollection \", \" métadonnées \": {\" généré \": 1462295443000, \" url \": \" http: //earthquake.usgs .gov / fdsnws / event / 1 / query? format = geojson & starttime = 2016-01-01 & endtime = 2016-01-31 & minmag = 6 & limit = 10 \", \" title \": \" USGS Earthquakes \", \" status \": 200, \" api \": \" 1.5.2 \", \" limit \": 10, \" offset \": 1, \" count \": 10}, \" features \": [ {\"type \": \"Feature \", \"properties \": {\"mag \": 7.2, \"place \": \"88 km au nord de Yelizovo, Russie \", \"time \" : 1454124312220, \"mis à jour \": 1460674294040, \"tz \": 720, \"url \": \"http: //earthquake.usgs.gov / earthquakes / eventpage / us20004vvx \", \" detail \": \" http: //earthquake.usgs.gov/fdsnws/event/1/query? eventid = us20004vvx & format = geojson \", \" feutre \": 2, \"cdi \": 3.4, \"mmi \": 5.82, \"alert \": \"green \", \"status \": \"review \", \"tsunami \": 1, \"sig \": 798, \"net \": \"us \", \"code \": \"20004vvx \", \"ids \": \", at00o1qxho, pt16030050, us20004vvx, gcmt20160130032510, \", \" sources \": \", at, pt, us, gcmt, \", \" types \": \", cap, dyfi, faute finie, general-link, general-text, geoserve, impact -link, impact-text, losspager, moment-tensor, proximité-villes, origine, phase-data, shakemap, tectonic-summary, \", \" nst \": null, \" dmin \": 0.958, \" rms \": 1.19, \"écart \": 17, \" magType \": \" mww \", \" type \": \" tremblement de terre \", \" title \": \" M 7,2 - 88 km au nord de Yelizovo, Russie \"} , \"géométrie \": {\"type \": \"Point \", \"coordonnées \": [158.5463,53.9776,177]}, \"id \": \"us20004vvx \"}, \n "+
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 6.1, \" place \" : \" 94 km SSE de Taron, Papouasie-Nouvelle-Guinée \" , \" heure \" : 1453777820750, \" mise à jour \" : 1460156775040, \" tz \" : 600, \" url \" : \" http: //earthquake.usgs.gov / tremblements de terre / eventpage / us20004uks \" , \"détail \" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us20004uks&format=geojson \" , \" feutre \" : null, \" cdi \" : null, \" mmi \" : 4.1, \" alert \" : \" green \" , \" status \" : \" review \" , \" tsunami \" : 1, \" sig \" : 572, \"net \" : \" us\" , \" code \" : \" 20004uks \" , \" ids \" : \" , us20004uks, gcmt20160126031023, \" , \" sources \" : \" , us, gcmt, \" , \" types \" : \" , cap, géoserve, losspager, tenseur de moment, villes proches, origine, données de phase, shakemap, résumé tectonique, \" , \" nst \" : null, \" dmin \" : 1.537 , \"rms \" : 0,74, \"écart \" : 25, \" magType \" : \" mww \" , \" type \" : \" tremblement de terre \" , \" title \" : \" M 6.1 - 94 km au SSE de Taron, Papouasie-Nouvelle-Guinée \" }, \" géométrie \" : { \" type \" : \" Point \" , \" coordonnées \" : [153.2454, -5.2952,26]}, \" id \" :\" us20004uks \"}, \" n "  +
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 6.3, \" place \" : \" 50 km NNE d'Al Hoceima, Maroc \" , \" heure \" : 1453695722730, \" mis à jour \" : 1460156773040, \" tz \" : 0, \" url \" : \" http: //earthquake.usgs.gov / tremblements de terre / eventpage / us10004gy9 \" , \" detail\" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004gy9&format=geojson \" , \" feutre \" : 117, \" cdi \" : 7.2, \" mmi \" : 5.28, \" alerte \" : \" vert \" , \" état \" : \" révisé \" , \" tsunami \" : 0, \" sig \" : 695, \" net \": \" nous \", \" code \" : \" 10004gy9 \" , \" ids \" : \" , us10004gy9, gcmt20160125042203, \" , \" sources \" : \" , us, gcmt, \" , \" types \" : \" , cap, dyfi, géoserve, impact-text, losspager, moment-tensor, proximité-villes, origine, phase-data, shakemap, tectonic-summary, \" , \" nst \" : null, \" dmin \" : 2.201, \"rms \" : 0,92,\" gap \" : 20, \" magType \" : \" mww \" , \" type \" : \" earthquake \" , \" title \" : \" M 6,3 - 50 km au NNE d'Al Hoceima, Maroc \" }, \" géométrie \" : { \" type \" : \" Point \" , \" coordonnées \" : [- 3.6818,35.6493,12]}, \" id \": \" us10004gy9\" }, \" n "  +
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 7.1, \" place \" : \" 86km E de Old Iliamna, Alaska \" , \" time \" : 1453631430230, \" mis à jour \" : 1460156770040, \" tz \" : -540, \" url \" : \" http: //earthquake.usgs.gov / tremblements de terre / eventpage / us10004gqp \" , \" detail\" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004gqp&format=geojson \" , \" feutre \" : 1816, \" cdi \" : 7.2, \" mmi \" : 6.6, \" alerte \" : \" vert \" , \" état \" : \" révisé \" , \" tsunami \" : 1, \" sig \" : 1496, \" net \": \" nous \", \" code \" : \" 10004gqp \" , \" ids \" : \" , at00o1gd6r, us10004gqp, ak12496371, gcmt20160124103030, \" , \" sources \" : \" , at, us, ak, gcmt, \" , \" types \" : \" , cap, dyfi, faute finie, general-link, general-text, geoserve, impact-link, impact-text, losspager, moment-tenseur, villes-proches, origine, données de phase, shakemap, résumé tectonique, origine atout, \" , \" nst \" : null,\" dmin \": 0,72, \" rms \" : 2.11, \" gap \" : 19, \" magType \" : \" mww \" , \" type \" : \" earthquake \" , \" title \" : \" M 7.1 - 86 km à l'est de Old Iliamna, Alaska \" }, \" géométrie \" : { \" type \" : \" Point \" , \" coordonnées \": [- 153.4051,59.6363,129]}, \"id \" : \" us10004gqp \" }, \n "  +
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 6.6, \" place \" : \" 215km SW de Tomatlan, Mexique \" , \" time \" : 1453399617650, \" mis à jour \" : 1459963829040, \" tz \" : -420, \" url \" : \" http: //earthquake.usgs.gov / tremblements de terre / eventpage / us10004g4l \" , \" detail\" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004g4l&format=geojson \" , \" feutre \" : 11, \" cdi \" : 2.7, \" mmi \" : 3.92, \" alerte \" : \" vert \" , \" état \" : \" révisé \" , \" tsunami \" : 1, \" sig \" : 673, \" net \": \" nous \", \" code \" : \" 10004g4l \" , \" ids \" : \" , at00o1bebo, pt16021050, us10004g4l, gcmt20160121180659, \" , \" sources \" : \" , at, pt, us, gcmt, \" , \" types \" : \" , cap, dyfi, geoserve, impact-link, impact-text, losspager, moment-tensor, proximité-villes, origine, phase-data, shakemap, tectonic-summary, \" , \" nst \" : null, \" dmin \": 2.413, \" rms\" : 0,98, \" écart \" : 74, \" magType \" : \" mww \" , \" type \" : \" tremblement de terre \" , \" title \" : \" M 6,6 - 215 km SW de Tomatlan, Mexique \" }, \" géométrie \" : { \" type \" : \" Point \" , \" coordonnées \" : [- 106.9337,18.8239,10]}, \"id \" : \"us10004g4l \" }, \n "  +
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 6.7, \" place \" : \" 52 km au SE de Shizunai, Japon \" , \" time \" : 1452741933640, \" mis à jour \" : 1459304879040, \" tz \" : 540, \" url \" : \" http: //earthquake.usgs.gov / tremblements de terre / eventpage / us10004ebx \" , \" detail\" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004ebx&format=geojson \" , \" feutre \" : 51, \" cdi \" : 5.8, \" mmi \" : 6.45, \" alerte \" : \" vert \" , \" état \" : \" révisé \" , \" tsunami \" : 1, \" sig \" : 720, \" net \": \" nous \", \" code \" : \" 10004ebx \" , \" ids \" : \" , us10004ebx, pt16014050, at00o0xauk, gcmt20160114032534, \" , \" sources \" : \" , us, pt, at, gcmt, \" , \" types \" : \" , associé, cap, dyfi, geoserve, impact-link, impact-text, losspager, moment-tensor, proximité-villes, origine, phase-data, shakemap, \" , \" nst \" : null, \" dmin \" : 0,281,\" rms\" : 0,98, \" écart \" : 22, \" magType \" : \" mww \" , \" type \" : \" tremblement de terre \" , \" title \" : \" M 6,7 - 52 km SE de Shizunai, Japon \" }, \" géométrie \" : { \" type \" : \" Point \" , \" coordonnées \" : [142.781,41.9723,46]}, \"id \" : \"us10004ebx \" }, \n "  +
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 6.1, \" place \" : \" 12km WNW de Charagua, Bolivie \" , \" time \" : 1452741928270, \" mis à jour \" : 1459304879040, \" tz \" : -240, \" url \" : \" http: //earthquake.usgs.gov / tremblements de terre / eventpage / us10004ebw \" , \" detail\" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004ebw&format=geojson \" , \" feu \" : 3, \" cdi \" : 2.2, \" mmi \" : 2.21, \" alerte \" : \" vert \" , \" état \" : \" révisé \" , \" tsunami \" : 0, \" sig \" : 573, \" net \" :\" nous \" ,\" code \" : \" 10004ebw \" , \" ids \" : \" , us10004ebw, gcmt20160114032528, \" , \" sources \" : \" , us, gcmt, \" , \" types \" : \" , cap, dyfi, géoserve, impact-text, losspager, moment-tensor, proximité-villes, origine, phase-data, shakemap, tectonic-summary, \" , \" nst \" : null, \" dmin \" : 5.492, \"rms \" : 1,04, \"écart \" : 16, \" magType \" : \" mww \" , \" type \" : \" tremblement de terre \" , \" title \" : \" M 6.1 - 12 km à l'ouest-ouest de Charagua, Bolivie \" } , \" géométrie \" : { \" type \" : \" Point \" , \" coordonnées \" : [- 63.3288, -19.7597,582.56]}, \" id \" :\" us10004ebw \"}, \n "  +
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 6.2, \" place \" : \" 74 km au nord-ouest de Rumoi, Japon \" , \" time \" : 1452532083920, \" mis à jour \" : 1459304875040, \" tz \" : 540, \" url \" : \" http: //earthquake.usgs.gov / tremblements de terre / eventpage / us10004djn \" , \" detail\" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004djn&format=geojson \" , \" feu \" : 8, \" cdi \" : 3.4, \" mmi \" : 3,74, \" alerte \" : \" vert \" , \" état \" : \" révisé \" , \" tsunami \" : 0, \" sig \" : 594, \" net \" :\" nous \" ,\" code \" : \" 10004djn \" , \" ids \" : \" , us10004djn, gcmt20160111170803, \" , \" sources \" : \" , us, gcmt, \" , \" types \" : \" , cap, dyfi, géoserve, impact-text, losspager, moment-tensor, proximité-villes, origine, phase-data, shakemap, tectonic-summary, \" , \" nst \" : null, \" dmin \" : 1.139, \"rms \" : 0,96, \"écart \" : 33, \" magType \" : \" mww \" , \" type \" : \" tremblement de terre \" , \" titre \" : \" M 6,2 - 74 km au NO de Rumoi, Japon \" } , \" géométrie \" : { \" type \" : \" Point \" , \" coordonnées \" : [141.0867,44.4761,238.81]}, \" id \" :\" us10004djn \"}, \n "  +
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 6.5, \" place \" : \" 227km SE de Sarangani, Philippines \" , \" time \" : 1452530285900, \" mis à jour \" : 1459304874040, \" tz \" : 480, \" url \" : \" http: //earthquake.usgs.gov / tremblements de terre / eventpage / us10004dj5 \" , \"détail \" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004dj5&format=geojson \" , \" feutre \" : 1, \" cdi \" : 2.7, \" mmi \" : 7.5, \" alert \" : \" green \" , \" status \" : \" review \" , \" tsunami \" : 1, \" sig \" : 650, \"net \" : \" us\" , \" code \" : \" 10004dj5 \" , \" ids \" : \" , at00o0srjp, pt16011050, us10004dj5, gcmt20160111163807, \" , \" sources \" : \" , at, pt, us, gcmt, \" , \" types \" : \" , cap, dyfi, geoserve, impact-link, impact-text, losspager, moment-tensor, proximité-villes, origine, phase-data, shakemap, tectonic-summary, \" , \" nst \" : null, \" dmin \" : 3.144, \"rms \" : 0,72, \" gap \" : 22, \" magType \" : \" mww \" , \" type \" : \" earthquake \" , \" title \" : \" M 6,5 - 227 km SE de Sarangani, Philippines \" }, \" géométrie \" : { \" type \" : \" Point \" , \" coordonnées \" : [126.8621,3.8965,13]},\" id \": \" us10004dj5 \" }, \n "  +
        " { \" type \" : \" Feature \" , \" properties \" : { \" mag \" : 6, \" place \" : \" Pacific-Antarctic Ridge \" , \" time \" : 1451986454620, \" updated \" : 1459202978040, \" tz \" : -540, \" url \" : \" http://earthquake.usgs.gov/earthquakes/eventpage/us10004bgk \", \" détail \" : \" http://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004bgk&format=geojson \" , \" feutre \" : 0, \" cdi \" : 1, \" mmi \" : 0, \" alerte \" : \" vert \" , \" état \" : \" révisé \" , \" tsunami \" : 0, \" sig \" : 554, \" net \" :\" nous \" ,\" code \" : \" 10004bgk \" , \" ids \" : \" , us10004bgk, gcmt20160105093415, \" , \" sources \" : \" , us, gcmt, \" , \" types \" : \" , cap, dyfi, geoserve, losspager, moment-tensor, proximité-villes, origine, phase-data, shakemap, \" , \" nst \" : null, \" dmin \" : 30.75, \" rms \" : 0,67,\" écart \": 71, \" magType \" : \" mww \" , \" type \" : \" tremblement de terre \" , \" title \" : \" M 6.0 - Pacific-Antarctic Ridge \" }, \" geometry \" : { \" type \" : \" Point \" , \" coordonnées \" : [- 136.2603, -54.2906,10]}, \" id \" : \"us10004bgk \" }], \"bbox \" : [- 153.4051, -54.2906,10,158.5463,59.6363,582.56]} " ;

        /**
        * Créez un constructeur privé car personne ne devrait jamais créer un objet { @link QueryUtils}.
        * Cette classe est uniquement destinée à contenir des méthodes et des variables statiques, accessibles
        * directement à partir du nom de classe QueryUtils (et une instance d'objet de QueryUtils n'est pas nécessaire).
        **/
        public QueryUtils() throws JSONException {
    //this.extractEarthquakes();
        }

        /**
        * Renvoyer une liste d' objets { @link Earthquake} qui a été construite à partir de
        * analyser une réponse JSON.
        */
public  static  ArrayList <Earthquake>  extractEarthquakes () throws JSONException {

    ArrayList<Earthquake> earthquakes = new ArrayList<>();

    try {

        // Créez une ArrayList vide à laquelle nous pouvons commencer à ajouter des tremblements de terre

        JSONObject basejsonResponse;
        basejsonResponse = new JSONObject( SAMPLE_JSON_RESPONSE );
        JSONArray earthquakeArray;
        earthquakeArray = basejsonResponse.getJSONArray( "features" );

        for (int i = 0; i < earthquakeArray.length(); i++) {
            JSONObject currentEarthquake = earthquakeArray.getJSONObject( i );

            JSONObject proprerties = currentEarthquake.getJSONObject( "properties" );


            String magnitude = proprerties.getString( "mag" );


            String location = proprerties.getString( "place" );


            String time = proprerties.getString( "time" );

            long timeInMilliseconds = 1454124312220L;
            Date dateObject = new Date(timeInMilliseconds);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
            String dateToDisplay = dateFormatter.format(dateObject);

            earthquakes.add( new Earthquake( magnitude, location, dateToDisplay ) );

        }
    } catch (JSONException e) {
        // Si une erreur est levée lors de l'exécution de l'une des instructions ci-dessus dans le bloc "try",
        // intercepte l'exception ici, afin que l'application ne plante pas. Imprimer un message de journal
        // avec le message de l'exception.
        Log.e( " QueryUtils ", " Problème d'analyse des résultats JSON du tremblement de terre ", e );
    }

    // Retourne la liste des tremblements de terre

    return earthquakes;
}}