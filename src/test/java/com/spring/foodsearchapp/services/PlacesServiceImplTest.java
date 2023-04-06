package com.spring.foodsearchapp.services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.spring.foodsearchapp.model.*;
import com.spring.foodsearchapp.model.directions.*;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlacesServiceImplTest {
    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Test
    void getPlaces() throws JsonProcessingException {
        String json = "{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":{\"name\":\"A&W\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48126\",\"suburb\":\"Fairlane Town Center\",\"street\":\"Town Center Drive\",\"housenumber\":\"210\",\"lon\":-83.22415782749124,\"lat\":42.32062055,\"state_code\":\"MI\",\"formatted\":\"A&W, 210 Town Center Drive, Dearborn, MI 48126, United States of America\",\"address_line1\":\"A&W\",\"address_line2\":\"210 Town Center Drive, Dearborn, MI 48126, United States of America\",\"categories\":[\"building\",\"building.catering\",\"catering\",\"catering.fast_food\",\"catering.fast_food.burger\"],\"details\":[\"details\",\"details.catering\",\"details.contact\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"A&W\",\"brand\":\"A&W\",\"phone\":\"+1-313-271-1676\",\"osm_id\":59150896,\"amenity\":\"fast_food\",\"cuisine\":\"burger\",\"building\":\"yes\",\"osm_type\":\"w\",\"takeaway\":\"yes\",\"addr:city\":\"Dearborn\",\"addr:state\":\"MI\",\"addr:street\":\"Town Center Drive\",\"addr:country\":\"US\",\"addr:postcode\":48126,\"drive_through\":\"yes\",\"brand:wikidata\":\"Q277641\",\"brand:wikipedia\":\"en:A&W Restaurants\",\"addr:housenumber\":210}},\"distance\":766,\"place_id\":\"5118aaf47e58ce54c059f74c56b409294540f00102f9013092860300000000920303412657\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.22415136235247,42.32060865606211]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Tim Hortons\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"West Dearborn Downtown\",\"street\":\"Michigan Avenue\",\"lon\":-83.23689391167866,\"lat\":42.30748415,\"state_code\":\"MI\",\"formatted\":\"Tim Hortons, Michigan Avenue, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Tim Hortons\",\"address_line2\":\"Michigan Avenue, Dearborn, MI 48124, United States of America\",\"categories\":[\"building\",\"building.catering\",\"catering\",\"catering.cafe\",\"catering.cafe.coffee\",\"catering.cafe.coffee_shop\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Tim Hortons\",\"brand\":\"Tim Hortons\",\"osm_id\":683578045,\"amenity\":\"cafe\",\"cuisine\":\"coffee_shop\",\"building\":\"yes\",\"osm_type\":\"w\",\"takeaway\":\"yes\",\"brand:wikidata\":\"Q175106\",\"brand:wikipedia\":\"en:Tim Hortons\"}},\"distance\":1137,\"place_id\":\"515685194529cf54c0597c5a2ca45b274540f00102f901bd92be280000000092030b54696d20486f72746f6e73\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.23689391605635,42.30748417058655]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Owl Night Lunch Wagon\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"village\":\"Greenfield Village\",\"postcode\":\"48124\",\"street\":\"Ford Road\",\"lon\":-83.2286319,\"lat\":42.3053444,\"state_code\":\"MI\",\"formatted\":\"Owl Night Lunch Wagon, Ford Road, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Owl Night Lunch Wagon\",\"address_line2\":\"Ford Road, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.fast_food\"],\"details\":[],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Owl Night Lunch Wagon\",\"osm_id\":1168616412,\"amenity\":\"fast_food\",\"osm_type\":\"n\"}},\"distance\":1360,\"place_id\":\"51a154b1e7a1ce54c059c2187b8615274540f00103f901dcaba745000000009203154f776c204e69676874204c756e6368205761676f6e\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2286319,42.3053444005068]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Qahwah House\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"Morley Area Residents Association\",\"street\":\"Michigan Avenue\",\"lon\":-83.2446334,\"lat\":42.306247,\"state_code\":\"MI\",\"formatted\":\"Qahwah House, Michigan Avenue, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Qahwah House\",\"address_line2\":\"Michigan Avenue, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.cafe\"],\"details\":[],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Qahwah House\",\"osm_id\":9905898368,\"amenity\":\"cafe\",\"organic\":\"yes\",\"osm_type\":\"n\"}},\"distance\":1585,\"place_id\":\"519820d912a8cf54c05967d6091a33274540f00103f9018003704e0200000092030c51616877616820486f757365\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2446334,42.30624700050685]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Cigaro\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"Morley Area Residents Association\",\"street\":\"Michigan Avenue\",\"lon\":-83.2447334,\"lat\":42.3058772,\"state_code\":\"MI\",\"formatted\":\"Cigaro, Michigan Avenue, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Cigaro\",\"address_line2\":\"Michigan Avenue, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.cafe\"],\"details\":[],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Cigaro\",\"osm_id\":2365262180,\"amenity\":\"cafe\",\"osm_type\":\"n\"}},\"distance\":1622,\"place_id\":\"51494f47b6a9cf54c0596962eefb26274540f00103f9016409fb8c0000000092030643696761726f\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.24473339999999,42.30587720050682]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Wendy's\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Detroit\",\"postcode\":\"48228\",\"street\":\"Ford Road\",\"housenumber\":\"18430\",\"lon\":-83.2196974477977,\"lat\":42.329418149999995,\"state_code\":\"MI\",\"formatted\":\"Wendy's, 18430 Ford Road, Detroit, MI 48228, United States of America\",\"address_line1\":\"Wendy's\",\"address_line2\":\"18430 Ford Road, Detroit, MI 48228, United States of America\",\"categories\":[\"building\",\"building.catering\",\"catering\",\"catering.fast_food\",\"catering.fast_food.burger\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Wendy's\",\"brand\":\"Wendy's\",\"osm_id\":227845279,\"amenity\":\"fast_food\",\"cuisine\":\"burger\",\"building\":\"yes\",\"osm_type\":\"w\",\"takeaway\":\"yes\",\"addr:city\":\"Detroit\",\"addr:street\":\"Ford Road\",\"addr:postcode\":48228,\"brand:wikidata\":\"Q550258\",\"brand:wikipedia\":\"en:Wendy's\",\"addr:housenumber\":18430}},\"distance\":1698,\"place_id\":\"515077529f0fce54c059bb06c0a92a2a4540f00102f9019fa4940d0000000092030757656e64792773\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.21970351270033,42.329426974070394]}},{\"type\":\"Feature\",\"properties\":{\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"village\":\"Greenfield Village\",\"postcode\":\"48124\",\"street\":\"Maple Lane\",\"lon\":-83.222233,\"lat\":42.3038515,\"state_code\":\"MI\",\"formatted\":\"Maple Lane, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Maple Lane\",\"address_line2\":\"Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.cafe\"],\"details\":[],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"osm_id\":1168679106,\"amenity\":\"cafe\",\"osm_type\":\"n\"}},\"distance\":1710,\"place_id\":\"51e3c5c21039ce54c05926c2209be4264540f00103f901c2a0a84500000000\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.222233,42.303851500506696]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Starbucks\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"West Dearborn Downtown\",\"street\":\"West Village Drive\",\"lon\":-83.2469201,\"lat\":42.3051528,\"state_code\":\"MI\",\"formatted\":\"Starbucks, West Village Drive, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Starbucks\",\"address_line2\":\"West Village Drive, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.cafe\",\"catering.cafe.coffee\",\"catering.cafe.coffee_shop\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Starbucks\",\"brand\":\"Starbucks\",\"osm_id\":1502463184,\"amenity\":\"cafe\",\"cuisine\":\"coffee_shop\",\"osm_type\":\"n\",\"takeaway\":\"yes\",\"official_name\":\"Starbucks Coffee\",\"brand:wikidata\":\"Q37158\",\"brand:wikipedia\":\"en:Starbucks\"}},\"distance\":1800,\"place_id\":\"51678ef689cdcf54c059ce3a393f0f274540f00103f901d0c48d5900000000920309537461726275636b73\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2469201,42.305152800506775]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Jimmy John's\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"West Dearborn Downtown\",\"street\":\"West Village Drive\",\"lon\":-83.2471683,\"lat\":42.3050785,\"state_code\":\"MI\",\"formatted\":\"Jimmy John's, West Village Drive, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Jimmy John's\",\"address_line2\":\"West Village Drive, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.fast_food\",\"catering.fast_food.sandwich\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Jimmy John's\",\"brand\":\"Jimmy John's\",\"osm_id\":1502464905,\"amenity\":\"fast_food\",\"cuisine\":\"sandwich\",\"osm_type\":\"n\",\"takeaway\":\"yes\",\"drive_through\":\"no\",\"official_name\":\"Jimmy John's Gourmet Sandwiches\",\"brand:wikidata\":\"Q1689380\",\"brand:wikipedia\":\"en:Jimmy John's\"}},\"distance\":1820,\"place_id\":\"51e746fd9ad1cf54c059d631f3cf0c274540f00103f90189cb8d590000000092030c4a696d6d79204a6f686e2773\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.24716829999998,42.30507850050678]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Famous Hamburger\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"Morley Area Residents Association\",\"street\":\"Michigan Avenue\",\"housenumber\":\"22207\",\"lon\":-83.2480972,\"lat\":42.3050759,\"state_code\":\"MI\",\"formatted\":\"Famous Hamburger, 22207 Michigan Avenue, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Famous Hamburger\",\"address_line2\":\"22207 Michigan Avenue, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.fast_food\"],\"details\":[],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Famous Hamburger\",\"osm_id\":5954553463,\"amenity\":\"fast_food\",\"osm_type\":\"n\",\"addr:city\":\"Dearborn\",\"addr:state\":\"MI\",\"addr:street\":\"Michigan Avenue\",\"addr:postcode\":48124,\"addr:housenumber\":22207}},\"distance\":1872,\"place_id\":\"51aa0e14d3e0cf54c059b8bc23ba0c274540f00103f9017746eb620100000092031046616d6f75732048616d627572676572\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.24809719999999,42.30507590050678]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Bubbleology\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"West Dearborn Downtown\",\"street\":\"West Village Drive\",\"lon\":-83.2490549,\"lat\":42.3045741,\"state_code\":\"MI\",\"formatted\":\"Bubbleology, West Village Drive, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Bubbleology\",\"address_line2\":\"West Village Drive, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.cafe\",\"catering.cafe.bubble_tea\",\"catering.cafe.tea\"],\"details\":[\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Bubbleology\",\"osm_id\":8735099410,\"amenity\":\"cafe\",\"cuisine\":\"bubble_tea\",\"osm_type\":\"n\",\"outdoor_seating\":\"yes\"}},\"distance\":1967,\"place_id\":\"51259af683f0cf54c0594c71bc48fc264540f00103f901120aa7080200000092030b427562626c656f6c6f6779\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.24905489999999,42.304574100506755]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Little Caesars\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48128\",\"street\":\"West Outer Drive\",\"lon\":-83.25744152293103,\"lat\":42.319894700000006,\"state_code\":\"MI\",\"formatted\":\"Little Caesars, West Outer Drive, Dearborn, MI 48128, United States of America\",\"address_line1\":\"Little Caesars\",\"address_line2\":\"West Outer Drive, Dearborn, MI 48128, United States of America\",\"categories\":[\"building\",\"building.catering\",\"catering\",\"catering.fast_food\",\"catering.fast_food.pizza\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Little Caesars\",\"brand\":\"Little Caesars\",\"osm_id\":319198471,\"amenity\":\"fast_food\",\"cuisine\":\"pizza\",\"building\":\"yes\",\"osm_type\":\"w\",\"takeaway\":\"yes\",\"brand:wikidata\":\"Q1393809\",\"brand:wikipedia\":\"en:Little Caesars\"}},\"distance\":2071,\"place_id\":\"51618744fe79d054c059d435b477f2284540f00102f901079506130000000092030e4c6974746c652043616573617273\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.25744587604778,42.31989952372865]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Jersey Mike's Subs\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"Morley Area\",\"street\":\"Michigan Avenue\",\"housenumber\":\"22439\",\"lon\":-83.2518474,\"lat\":42.3040516,\"state_code\":\"MI\",\"formatted\":\"Jersey Mike's Subs, 22439 Michigan Avenue, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Jersey Mike's Subs\",\"address_line2\":\"22439 Michigan Avenue, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.fast_food\",\"catering.fast_food.sandwich\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Jersey Mike's Subs\",\"brand\":\"Jersey Mike's Subs\",\"osm_id\":1503605151,\"amenity\":\"fast_food\",\"cuisine\":\"sandwich\",\"osm_type\":\"n\",\"takeaway\":\"yes\",\"addr:city\":\"Dearborn\",\"addr:state\":\"MI\",\"short_name\":\"Jersey Mike's\",\"addr:street\":\"Michigan Avenue\",\"addr:postcode\":48124,\"opening_hours\":\"10:00-21:00\",\"brand:wikidata\":\"Q6184897\",\"brand:wikipedia\":\"en:Jersey Mike's Subs\",\"addr:housenumber\":22439}},\"distance\":2173,\"place_id\":\"514aa58e441ed054c059843cb029eb264540f00103f9019f319f59000000009203124a6572736579204d696b6527732053756273\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2518474,42.30405160050671]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Biggby Coffee\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"Southwestern Outer Drive\",\"street\":\"Newman Street\",\"lon\":-83.2517728,\"lat\":42.3038986,\"state_code\":\"MI\",\"formatted\":\"Biggby Coffee, Newman Street, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Biggby Coffee\",\"address_line2\":\"Newman Street, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.cafe\",\"catering.cafe.coffee\",\"catering.cafe.coffee_shop\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Biggby Coffee\",\"brand\":\"Biggby Coffee\",\"osm_id\":1503605078,\"amenity\":\"cafe\",\"cuisine\":\"coffee_shop\",\"osm_type\":\"n\",\"takeaway\":\"yes\",\"brand:wikidata\":\"Q4906876\",\"brand:wikipedia\":\"en:Biggby Coffee\",\"outdoor_seating\":\"no\"}},\"distance\":2180,\"place_id\":\"516e81a90b1dd054c059fd3c3b26e6264540f00103f90156319f590000000092030d42696767627920436f66666565\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2517728,42.303898600506706]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Bellacino's Pizza & Grinders\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"Morley Area\",\"street\":\"Michigan Avenue\",\"housenumber\":\"22537\",\"lon\":-83.2527252,\"lat\":42.3031328,\"state_code\":\"MI\",\"formatted\":\"Bellacino's Pizza & Grinders, 22537 Michigan Avenue, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Bellacino's Pizza & Grinders\",\"address_line2\":\"22537 Michigan Avenue, Dearborn, MI 48124, United States of America\",\"categories\":[\"catering\",\"catering.fast_food\",\"catering.fast_food.pizza\"],\"details\":[\"details.catering\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Bellacino's Pizza & Grinders\",\"osm_id\":6402681808,\"amenity\":\"fast_food\",\"cuisine\":\"pizza\",\"osm_type\":\"n\",\"addr:city\":\"Dearborn\",\"addr:state\":\"MI\",\"addr:street\":\"Michigan Avenue\",\"addr:postcode\":48124,\"drive_through\":\"no\",\"addr:housenumber\":22537}},\"distance\":2296,\"place_id\":\"51013851a62cd054c059b1423c0ecd264540f00103f901d02ba17d0100000092031c42656c6c6163696e6f27732050697a7a612026204772696e64657273\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2527252,42.30313280050667]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Dairy Queen\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn Heights\",\"postcode\":\"48185\",\"street\":\"Ford Road\",\"lon\":-83.25826745905839,\"lat\":42.3274402,\"state_code\":\"MI\",\"formatted\":\"Dairy Queen, Ford Road, Dearborn Heights, MI 48185, United States of America\",\"address_line1\":\"Dairy Queen\",\"address_line2\":\"Ford Road, Dearborn Heights, MI 48185, United States of America\",\"categories\":[\"building\",\"building.catering\",\"building.commercial\",\"catering\",\"catering.fast_food\",\"catering.fast_food.burger\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Dairy Queen\",\"brand\":\"Dairy Queen\",\"osm_id\":315559924,\"amenity\":\"fast_food\",\"cuisine\":\"ice_cream;burger\",\"building\":\"retail\",\"osm_type\":\"w\",\"takeaway\":\"yes\",\"brand:wikidata\":\"Q1141226\",\"brand:wikipedia\":\"en:Dairy Queen\"}},\"distance\":2403,\"place_id\":\"515be2aa7187d054c059e7dd82b0e8294540f00102f901f40fcf120000000092030b446169727920517565656e\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2582668465415,42.327413619899566]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Boston Market\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48126\",\"street\":\"Mercury Drive\",\"housenumber\":\"5651\",\"lon\":-83.2071977,\"lat\":42.3297419,\"state_code\":\"MI\",\"formatted\":\"Boston Market, 5651 Mercury Drive, Dearborn, MI 48126, United States of America\",\"address_line1\":\"Boston Market\",\"address_line2\":\"5651 Mercury Drive, Dearborn, MI 48126, United States of America\",\"categories\":[\"catering\",\"catering.fast_food\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Boston Market\",\"brand\":\"Boston Market\",\"osm_id\":1354910559,\"amenity\":\"fast_food\",\"cuisine\":\"american;chicken\",\"website\":\"https://www.bostonmarket.com/location/mi/dearborn/5651-mercury-dr\",\"osm_type\":\"n\",\"takeaway\":\"yes\",\"brand:wikidata\":\"Q603617\",\"brand:wikipedia\":\"en:Boston Market\"}},\"distance\":2498,\"place_id\":\"519c5324ba42cd54c059e3668bfb342a4540f00103f9015f4bc2500000000092030d426f73746f6e204d61726b6574\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2071977,42.329741900508246]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Potbelly\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48124\",\"district\":\"Ford Homes District\",\"street\":\"Michigan Avenue\",\"housenumber\":\"22941\",\"lon\":-83.25811295,\"lat\":42.302617299999994,\"state_code\":\"MI\",\"formatted\":\"Potbelly, 22941 Michigan Avenue, Dearborn, MI 48124, United States of America\",\"address_line1\":\"Potbelly\",\"address_line2\":\"22941 Michigan Avenue, Dearborn, MI 48124, United States of America\",\"categories\":[\"building\",\"building.catering\",\"catering\",\"catering.fast_food\",\"catering.fast_food.sandwich\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Potbelly\",\"brand\":\"Potbelly\",\"osm_id\":443087495,\"amenity\":\"fast_food\",\"cuisine\":\"sandwich\",\"building\":\"yes\",\"osm_type\":\"w\",\"takeaway\":\"yes\",\"addr:city\":\"Dearborn\",\"addr:state\":\"MI\",\"addr:street\":\"Michigan Avenue\",\"addr:postcode\":48124,\"official_name\":\"Potbelly Sandwich Works\",\"brand:wikidata\":\"Q7234777\",\"brand:wikipedia\":\"en:Potbelly Sandwich Shop\",\"addr:housenumber\":22941}},\"distance\":2660,\"place_id\":\"5123bb2dec84d054c0599d70e829bc264540f00102f90187fa681a00000000920308506f7462656c6c79\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.25811294999998,42.30261730050663]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Jimmy John's\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48126\",\"street\":\"Ford Road\",\"housenumber\":\"16201\",\"lon\":-83.2017042,\"lat\":42.3264113,\"state_code\":\"MI\",\"formatted\":\"Jimmy John's, 16201 Ford Road, Dearborn, MI 48126, United States of America\",\"address_line1\":\"Jimmy John's\",\"address_line2\":\"16201 Ford Road, Dearborn, MI 48126, United States of America\",\"categories\":[\"catering\",\"catering.fast_food\",\"catering.fast_food.sandwich\"],\"details\":[\"details\",\"details.catering\",\"details.facilities\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Jimmy John's\",\"brand\":\"Jimmy John's\",\"osm_id\":2644262638,\"amenity\":\"fast_food\",\"cuisine\":\"sandwich\",\"website\":\"https://locations.jimmyjohns.com/mi/dearborn/sandwiches-580.htm\",\"osm_type\":\"n\",\"takeaway\":\"yes\",\"addr:city\":\"Dearborn\",\"addr:state\":\"MI\",\"addr:street\":\"Ford Rd\",\"addr:postcode\":48126,\"official_name\":\"Jimmy John's Gourmet Sandwiches\",\"brand:wikidata\":\"Q1689380\",\"brand:wikipedia\":\"en:Jimmy John's\",\"addr:housenumber\":16201}},\"distance\":2727,\"place_id\":\"51d09dbbb8e8cc54c0590b5d72d8c7294540f00103f901ee3e9c9d0000000092030c4a696d6d79204a6f686e2773\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2017042,42.32641130050805]}},{\"type\":\"Feature\",\"properties\":{\"name\":\"Einstein Bagels\",\"country\":\"United States\",\"country_code\":\"us\",\"state\":\"Michigan\",\"county\":\"Wayne County\",\"city\":\"Dearborn\",\"postcode\":\"48126\",\"street\":\"Mercury Drive\",\"housenumber\":\"5700\",\"lon\":-83.2036609,\"lat\":42.3311833,\"state_code\":\"MI\",\"formatted\":\"Einstein Bagels, 5700 Mercury Drive, Dearborn, MI 48126, United States of America\",\"address_line1\":\"Einstein Bagels\",\"address_line2\":\"5700 Mercury Drive, Dearborn, MI 48126, United States of America\",\"categories\":[\"catering\",\"catering.fast_food\"],\"details\":[\"details\",\"details.catering\",\"details.contact\"],\"datasource\":{\"sourcename\":\"openstreetmap\",\"attribution\":\"© OpenStreetMap contributors\",\"license\":\"Open Database Licence\",\"url\":\"https://www.openstreetmap.org/copyright\",\"raw\":{\"name\":\"Einstein Bagels\",\"phone\":\"(313) 271-9788\",\"osm_id\":9719654210,\"amenity\":\"fast_food\",\"cuisine\":\"bagel\",\"website\":\"https://locations.einsteinbros.com/us/mi/dearborn/5700-mercury-dr\",\"osm_type\":\"n\",\"addr:city\":\"Dearborn\",\"addr:state\":\"MI\",\"addr:street\":\"Mercury Drive\",\"addr:housenumber\":5700}},\"distance\":2829,\"place_id\":\"51553ebac708cd54c0591255e236642a4540f00103f901422756430200000092030f45696e737465696e20426167656c73\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-83.2036609,42.33118330050833]}}]}";
        FeatureCollection featureCollection = mapper.readValue(json, FeatureCollection.class);

//        List<Features> features = Lists.newArrayList(mapper.convertValue(featureCollection.getCollection(), Features[].class));
        List<Properties> propertiesList = new ArrayList<>();
        List<RawData> rawDataList = new ArrayList<>();

        Features[] features = mapper.convertValue(featureCollection.getFeatures(), Features[].class);
        for(Features feature : features) {
            Properties properties = mapper.convertValue(feature.getProperties(), Properties.class);
            propertiesList.add(properties);

            DataSource dataSource = mapper.convertValue(properties.getDatasource(), DataSource.class);

//            raw data object within datasource
            RawData rawData = mapper.convertValue(dataSource.getRaw(), RawData.class);
            rawDataList.add(rawData);
        }

//        The whole object
        assertNotNull(featureCollection);

//        The places
        assertNotNull(features[0]);
        assertNotNull(features[1]);

//        Properties from every place encapsulated in a list
        assertNotNull(propertiesList);
        assertEquals("A&W", propertiesList.get(0).getName());
        assertEquals(766, propertiesList.get(0).getDistance());
        assertEquals("5118aaf47e58ce54c059f74c56b409294540f00102f9013092860300000000920303412657", propertiesList.get(0).getPlace_id());

        assertEquals("Tim Hortons", propertiesList.get(1).getName());

//        Raw data list within datasource which is within properties
        assertNotNull(rawDataList);
        assertEquals("cafe", rawDataList.get(1).getAmenity());
        assertEquals("coffee_shop", rawDataList.get(1).getCuisine());
    }

    @Test
    void savePlace() {
    }

    @Test
    void getDirectionsByPlaceId() throws JsonProcessingException {
        String json = "{\"features\":[{\"type\":\"Feature\",\"properties\":{\"mode\":\"drive\",\"waypoints\":[{\"location\":[-83.231939,42.317229],\"original_index\":0},{\"location\":[-83.258267,42.32744],\"original_index\":1}],\"units\":\"metric\",\"distance\":5722,\"distance_units\":\"meters\",\"time\":440.262,\"legs\":[{\"distance\":5722,\"time\":440.262,\"steps\":[{\"from_index\":0,\"to_index\":16,\"distance\":147,\"time\":45.783,\"instruction\":{\"text\":\"Drive west.\"}},{\"from_index\":16,\"to_index\":51,\"distance\":643,\"time\":99.419,\"instruction\":{\"text\":\"Turn left onto Fair Lane Drive.\"}},{\"from_index\":51,\"to_index\":57,\"distance\":272,\"time\":19.945,\"instruction\":{\"text\":\"Turn right onto Evergreen Road.\"}},{\"from_index\":57,\"to_index\":58,\"distance\":44,\"time\":2.501,\"instruction\":{\"text\":\"Bear left to stay on Evergreen Road.\"}},{\"from_index\":58,\"to_index\":114,\"distance\":2263,\"time\":142.703,\"instruction\":{\"text\":\"Make a sharp left to stay on Evergreen Road.\"}},{\"from_index\":114,\"to_index\":174,\"distance\":2271,\"time\":108.928,\"instruction\":{\"text\":\"Take the M 153 West exit on the right.\"}},{\"from_index\":174,\"to_index\":177,\"distance\":46,\"time\":13.121,\"instruction\":{\"text\":\"Turn right.\"}},{\"from_index\":177,\"to_index\":182,\"distance\":34,\"time\":7.858,\"instruction\":{\"text\":\"Turn left.\"}},{\"from_index\":182,\"to_index\":182,\"distance\":0,\"time\":0,\"instruction\":{\"text\":\"Your destination is on the left.\"}}]}]},\"geometry\":{\"type\":\"MultiLineString\",\"coordinates\":[[[-83.232219,42.316472],[-83.232682,42.316566],[-83.23271,42.316492],[-83.232745,42.3164],[-83.232757,42.31637],[-83.232813,42.31636],[-83.232862,42.316342],[-83.232897,42.316317],[-83.232931,42.31627],[-83.23296,42.316141],[-83.232988,42.316076],[-83.233015,42.316015],[-83.233055,42.315963],[-83.233116,42.315923],[-83.233186,42.315886],[-83.233278,42.315836],[-83.233347,42.3158],[-83.232188,42.314778],[-83.232135,42.314737],[-83.23209,42.314678],[-83.23207,42.314608],[-83.232057,42.314558],[-83.232045,42.314524],[-83.232027,42.314499],[-83.231998,42.314481],[-83.231965,42.314463],[-83.231902,42.31444],[-83.231847,42.314423],[-83.231785,42.314399],[-83.231734,42.314363],[-83.231634,42.314279],[-83.231591,42.314244],[-83.23134,42.314035],[-83.231031,42.313791],[-83.230944,42.313726],[-83.230871,42.313681],[-83.230727,42.313601],[-83.230628,42.313545],[-83.230597,42.313528],[-83.230427,42.313442],[-83.230248,42.313357],[-83.230065,42.313278],[-83.229878,42.313208],[-83.229595,42.313115],[-83.229482,42.313085],[-83.229383,42.313061],[-83.229173,42.313011],[-83.229107,42.312995],[-83.228726,42.312908],[-83.228445,42.31286],[-83.228148,42.312822],[-83.227193,42.312715],[-83.227142,42.312512],[-83.227075,42.312097],[-83.226994,42.311599],[-83.226927,42.31127],[-83.226869,42.310755],[-83.22679,42.310284],[-83.226544,42.309933],[-83.22647,42.310192],[-83.226466,42.310227],[-83.226462,42.310288],[-83.226443,42.310521],[-83.226488,42.310821],[-83.22656,42.311291],[-83.226608,42.311511],[-83.226699,42.312071],[-83.226787,42.312644],[-83.226947,42.313881],[-83.22698,42.314008],[-83.227154,42.315057],[-83.227233,42.315323],[-83.227372,42.315724],[-83.227406,42.315799],[-83.227482,42.315965],[-83.227902,42.316622],[-83.228029,42.31682],[-83.228191,42.317063],[-83.228238,42.317128],[-83.228357,42.31729],[-83.228523,42.317478],[-83.228773,42.317823],[-83.228969,42.318097],[-83.229165,42.31837],[-83.229398,42.318696],[-83.229977,42.319472],[-83.230147,42.319699],[-83.230485,42.320152],[-83.230695,42.320446],[-83.230717,42.320477],[-83.230787,42.320575],[-83.231136,42.321064],[-83.231349,42.321361],[-83.231672,42.321709],[-83.232056,42.322049],[-83.232427,42.322326],[-83.232513,42.322398],[-83.232721,42.322571],[-83.232989,42.32287],[-83.233137,42.323118],[-83.233273,42.323345],[-83.233426,42.323701],[-83.233524,42.32411],[-83.233562,42.324286],[-83.233597,42.324452],[-83.23374,42.325106],[-83.233838,42.325586],[-83.23387,42.325755],[-83.233954,42.326205],[-83.234005,42.326472],[-83.234245,42.327692],[-83.234359,42.328204],[-83.234416,42.328461],[-83.234498,42.328861],[-83.234512,42.328935],[-83.234493,42.329384],[-83.234452,42.329506],[-83.234377,42.329583],[-83.234274,42.329655],[-83.23414,42.329722],[-83.234009,42.329749],[-83.233843,42.329754],[-83.233656,42.329723],[-83.233511,42.329645],[-83.233403,42.329546],[-83.233338,42.329421],[-83.233331,42.329311],[-83.233366,42.329189],[-83.23346,42.329073],[-83.23357,42.328993],[-83.233798,42.328915],[-83.235208,42.328794],[-83.235469,42.32879],[-83.236398,42.328786],[-83.237302,42.328774],[-83.238226,42.328752],[-83.238761,42.328724],[-83.239348,42.328685],[-83.239819,42.328635],[-83.239935,42.328616],[-83.240342,42.328551],[-83.240871,42.328457],[-83.241906,42.328253],[-83.242051,42.328223],[-83.243879,42.327861],[-83.24475,42.327689],[-83.245353,42.327589],[-83.245819,42.32752],[-83.246392,42.327462],[-83.246785,42.327437],[-83.247154,42.327422],[-83.247526,42.327411],[-83.248845,42.327377],[-83.24914,42.327374],[-83.249202,42.327373],[-83.249307,42.327372],[-83.251228,42.327313],[-83.252236,42.327289],[-83.252923,42.327269],[-83.253018,42.327266],[-83.253117,42.327263],[-83.253222,42.327261],[-83.253899,42.327243],[-83.254144,42.327237],[-83.254384,42.327231],[-83.255349,42.327206],[-83.255544,42.327201],[-83.256315,42.327181],[-83.256565,42.327178],[-83.256851,42.327167],[-83.257279,42.327156],[-83.257496,42.32715],[-83.257683,42.327146],[-83.257815,42.327142],[-83.258026,42.327137],[-83.25804,42.327242],[-83.258053,42.327343],[-83.258071,42.327556],[-83.258191,42.327562],[-83.258282,42.327554],[-83.258344,42.327527],[-83.258365,42.327486],[-83.258358,42.327434]]]}}],\"properties\":{\"mode\":\"drive\",\"waypoints\":[{\"lat\":42.3172294,\"lon\":-83.23193935538828},{\"lat\":42.3274402,\"lon\":-83.25826745905839}],\"units\":\"metric\"},\"type\":\"FeatureCollection\"}\n";

        Collection featureCollection = mapper.readValue(json, Collection.class);

        DirectionsFeatures[] features = mapper.convertValue(featureCollection.getFeatures(), DirectionsFeatures[].class);

        assertNotNull(featureCollection);
        assertNotNull(features);

        DirectionProps properties = mapper.convertValue(features[0].getProperties(), DirectionProps.class);

        assertNotNull(properties);

        Legs[] legs = mapper.convertValue(properties.getLegs(), Legs[].class);

        Steps[] steps = mapper.convertValue(legs[0].getSteps(), Steps[].class);

        for(Steps step: steps) {
            assertNotNull(step);
        }

    }
}