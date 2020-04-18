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

        private static final  String SAMPLE_JSON_RESPONSE = "{\"type\":\"FeatureCollection\",\"metadata\":{\"generated\":1587217916000,\"url\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_day.geojson\",\"title\":\"USGS Magnitude 4.5+ Earthquakes, Past Day\",\"status\":200,\"api\":\"1.8.1\",\"count\":11},\"features\":[{\"type\":\"Feature\",\"properties\":{\"mag\":5.7,\"place\":\"213km W of Chichi-shima, Japan\",\"time\":1587201857792,\"updated\":1587209290841,\"tz\":540,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008za4\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008za4.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":0,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":500,\"net\":\"us\",\"code\":\"70008za4\",\"ids\":\",us70008za4,\",\"sources\":\",us,\",\"types\":\",geoserve,losspager,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":1.889,\"rms\":0.81,\"gap\":53,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 5.7 - 213km W of Chichi-shima, Japan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[140.0669,27.187,467.68]},\"id\":\"us70008za4\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":4.6,\"place\":\"32km W of Fiambala, Argentina\",\"time\":1587198471238,\"updated\":1587212695668,\"tz\":-180,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008z8a\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008z8a.geojson\",\"felt\":1,\"cdi\":2.7,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":326,\"net\":\"us\",\"code\":\"70008z8a\",\"ids\":\",us70008z8a,\",\"sources\":\",us,\",\"types\":\",dyfi,geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":1.349,\"rms\":0.94,\"gap\":138,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.6 - 32km W of Fiambala, Argentina\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-67.9473,-27.6846,132.73]},\"id\":\"us70008z8a\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":6.6,\"place\":\"209km W of Chichi-shima, Japan\",\"time\":1587198337201,\"updated\":1587217399852,\"tz\":540,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008z89\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008z89.geojson\",\"felt\":34,\"cdi\":3.4,\"mmi\":0,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":682,\"net\":\"us\",\"code\":\"70008z89\",\"ids\":\",at00q8z62q,us70008z89,pt20109000,\",\"sources\":\",at,us,pt,\",\"types\":\",dyfi,geoserve,impact-link,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":1.853,\"rms\":0.75,\"gap\":34,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.6 - 209km W of Chichi-shima, Japan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[140.1061,27.1398,453.77]},\"id\":\"us70008z89\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":4.8,\"place\":\"Mid-Indian Ridge\",\"time\":1587195283708,\"updated\":1587197258040,\"tz\":300,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008z81\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008z81.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":354,\"net\":\"us\",\"code\":\"70008z81\",\"ids\":\",us70008z81,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":20.583,\"rms\":0.62,\"gap\":149,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.8 - Mid-Indian Ridge\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[69.5236,-23.6868,10]},\"id\":\"us70008z81\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":4.7,\"place\":\"188km ESE of Neiafu, Tonga\",\"time\":1587180715280,\"updated\":1587182729040,\"tz\":-660,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008z4d\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008z4d.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":340,\"net\":\"us\",\"code\":\"70008z4d\",\"ids\":\",us70008z4d,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":2.367,\"rms\":1.13,\"gap\":102,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.7 - 188km ESE of Neiafu, Tonga\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-172.4016,-19.4561,10]},\"id\":\"us70008z4d\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":4.9,\"place\":\"Central Mid-Atlantic Ridge\",\"time\":1587175689511,\"updated\":1587177056040,\"tz\":-60,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008z2x\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008z2x.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":369,\"net\":\"us\",\"code\":\"70008z2x\",\"ids\":\",us70008z2x,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":10.381,\"rms\":0.71,\"gap\":52,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.9 - Central Mid-Atlantic Ridge\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-22.1844,-1.0311,10]},\"id\":\"us70008z2x\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":4.6,\"place\":\"28km ESE of Agrihan, Northern Mariana Islands\",\"time\":1587166431050,\"updated\":1587168221040,\"tz\":600,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008z0b\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008z0b.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":326,\"net\":\"us\",\"code\":\"70008z0b\",\"ids\":\",us70008z0b,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":3.406,\"rms\":0.68,\"gap\":96,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.6 - 28km ESE of Agrihan, Northern Mariana Islands\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[145.9126,18.6644,149.64]},\"id\":\"us70008z0b\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":5.7,\"place\":\"Mid-Indian Ridge\",\"time\":1587141048429,\"updated\":1587150104040,\"tz\":300,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008yn9\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008yn9.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":0,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":500,\"net\":\"us\",\"code\":\"70008yn9\",\"ids\":\",us70008yn9,\",\"sources\":\",us,\",\"types\":\",geoserve,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":16.52,\"rms\":1.02,\"gap\":69,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 5.7 - Mid-Indian Ridge\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[69.4332,-23.7683,10]},\"id\":\"us70008yn9\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":4.5,\"place\":\"190km ESE of Kimbe, Papua New Guinea\",\"time\":1587139540617,\"updated\":1587140687040,\"tz\":600,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008yld\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008yld.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":312,\"net\":\"us\",\"code\":\"70008yld\",\"ids\":\",us70008yld,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":2.028,\"rms\":1.36,\"gap\":179,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.5 - 190km ESE of Kimbe, Papua New Guinea\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[151.7427,-6.1888,10]},\"id\":\"us70008yld\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":4.5,\"place\":\"31km N of Tasiilaq, Greenland\",\"time\":1587135414495,\"updated\":1587144175040,\"tz\":-180,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008yib\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008yib.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":312,\"net\":\"us\",\"code\":\"70008yib\",\"ids\":\",us70008yib,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":0.279,\"rms\":1.16,\"gap\":68,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.5 - 31km N of Tasiilaq, Greenland\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-37.684,65.8939,10]},\"id\":\"us70008yib\"},\n" +
                "{\"type\":\"Feature\",\"properties\":{\"mag\":4.6,\"place\":\"266km ENE of Fais, Micronesia\",\"time\":1587132411104,\"updated\":1587144572040,\"tz\":600,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us70008yhc\",\"detail\":\"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us70008yhc.geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":326,\"net\":\"us\",\"code\":\"70008yhc\",\"ids\":\",us70008yhc,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":3.622,\"rms\":0.71,\"gap\":146,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.6 - 266km ENE of Fais, Micronesia\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[142.823,10.5514,26.22]},\"id\":\"us70008yhc\"}],\"bbox\":[-172.4016,-27.6846,10,151.7427,65.8939,467.68]}" ;

        /**
        * Créez un constructeur privé car personne ne devrait jamais créer un objet { @link QueryUtils}.
        * Cette classe est uniquement destinée à contenir des méthodes et des variables statiques, accessibles
        * directement à partir du nom de classe QueryUtils (et une instance d'objet de QueryUtils n'est pas nécessaire).
        **/
        public QueryUtils() {
    //this.extractEarthquakes();
        }

        /**
        * Renvoyer une liste d' objets { @link Earthquake} qui a été construite à partir de
        * analyser une réponse JSON.
        */
public  static  ArrayList <Earthquake>  extractEarthquakes ()  {

    ArrayList<Earthquake> earthquakes = new ArrayList<>();

    try {

        // Créez une ArrayList vide à laquelle nous pouvons commencer à ajouter des tremblements de terre

        JSONObject basejsonResponse;
        basejsonResponse = new JSONObject( SAMPLE_JSON_RESPONSE );
        JSONArray earthquakeArray;
        earthquakeArray = basejsonResponse.getJSONArray( "features" );

        for (int i = 0; i < earthquakeArray.length(); i++) {
            JSONObject currentEarthquake = earthquakeArray.getJSONObject( i );

            JSONObject properties = currentEarthquake.getJSONObject( "properties" );
            if (properties == null) { // In your case we dont have any other things to get so continue
                continue;
            }

            String magnitude = properties.getString( "mag" );


            String location = properties.getString( "place" );

            long time = properties.getLong("time");

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
}
}