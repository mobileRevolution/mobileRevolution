package com.example.dmitry.mobilerevolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Product> products = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set RecyclerView
        setTestData();

        rv = (RecyclerView)findViewById(R.id.activityMainRecyclerView);
        rv.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        rv.setLayoutManager( linearLayoutManager);
        AdapterRecycleView adapter = new AdapterRecycleView(this, products);
        rv.setAdapter(adapter);

    }

    private void setTestData() {
       // Product p = new Product();
        products.add(new Product("Bread", null,"Bread is a staple food prepared from a dough of flour and water, usually by baking. Throughout recorded history it has been popular around the world and is one of the oldest artificial foods, having been of importance since the dawn of agriculture.\n" +
                "\n" +
                "Proportions of types of flour and other ingredients vary widely, as do modes of preparation. As a result, types, shapes, sizes, " +
                "and textures of breads differ around the world. Bread may be leavened by processes such as reliance on naturally occurring sourdough " +
                "microbes, chemicals, industrially produced yeast, or high-pressure aeration. Some bread is cooked before it can leaven, including for traditional or religious " +
                "reasons. Non-cereal ingredients such as fruits, nuts and fats may be included." +
                " Commercial bread commonly contains additives to improve flavor, " +
                "texture, color, shelf life, and ease of manufacturing."));
        products.add(new Product("Milk", null,"Milk is a white liquid produced by the mammary glands of mammals. It is the primary source of nutrition for infant mammals (including humans who breastfeed) before they are able to digest other types of food. Early-lactation milk contains colostrum, which carries the mother's antibodies to its young and can reduce the risk of many diseases. It contains many other nutrients[1] including protein and lactose.\n" +
                "\n" +
                "As an agricultural product, milk is extracted from non-human mammals during or soon after pregnancy. " +
                "Dairy farms produced about 730 million tonnes of milk in 2011,[2] from 260 million dairy cows.[3] India is the world's " +
                "largest producer of milk, and is the leading exporter of skimmed milk powder, yet it exports few other milk products.[4][5] The ever increasing " +
                "rise in domestic demand for dairy products and a large demand-supply gap could lead to India being a net importer of dairy products in the future.[6] The United States, India, " +
                "China and Brazil are the world's largest exporters of milk and milk products.[7] China and Russia were the world's largest importers " +
                "of milk and milk products until 2016 when both countries became self-sufficient, contributing to a worldwide glut of milk.[8]"));

        products.add(new Product("Sweet", null,"When it comes to eating healthfully, most people wonder where sweets fit " +
                "in, especially if they are overweight or on a diet. Desserts, chips, junk food, and most sweets are usually the first to go when slashing calories.\n" +
                "\n" +
                "Not so fast, say the experts."));
        products.add(new Product("Tea", null,"Tea is an aromatic beverage commonly prepared by pouring hot or boiling water over cured leaves of the Camellia sinensis, an evergreen shrub native to Asia.[3] After water, it is the most widely consumed drink in the world.[4] There are many different types of tea; some teas, like Darjeeling and Chinese greens, have a cooling, slightly bitter, and astringent flavour,[5] while others have vastly different profiles that include sweet, nutty, floral or grassy notes.\n" +
                "\n" +
                "Tea originated in Southwest China, where it was used as a medicinal drink.[6] It was popularized as a recreational drink during" +
                " the Chinese Tang dynasty, and tea drinking spread to other East Asian countries. Portuguese priests and merchants introduced it to " +
                "Europe during the 16th century.[7] During the 17th century, drinking tea became fashionable among Britons, who started large-scale production" +
                " and commercialization of the plant in India to bypass the Chinese monopoly."));
        products.add(new Product("Coffe", null,"Coffee is a brewed drink prepared from roasted coffee beans, which are the " +
                "seeds of berries from the Coffea plant. The genus Coffea is native to tropical Africa (specifically having its origin in " +
                "Ethiopia and Sudan) and Madagascar, the Comoros, Mauritius, and Réunion in the Indian Ocean.[2] The plant was exported from Africa to c" +
                "ountries around the world and coffee plants are now cultivated in over 70 countries, primarily in the equatorial regions of the Americas, Southea" +
                "st Asia, India, and Africa. The two most commonly grown are the highly regarded arabica, and the less sophisticated but stronger and more hardy robusta. Once ripe, coffee b" +
                "erries are picked, processed, and dried. Dried coffee seeds (referred to as beans) are roasted to varying degrees, depending on the desired flavor." +
                " Roasted beans are ground and brewed with near-boiling water to produce coffee as a beverage."));
        products.add(new Product("Apple", null,"The apple tree (Malus pumila, commonly and erroneously called Malus domestica) is a deciduous tree " +
                "in the rose family best known for its sweet, pomaceous fruit, the apple. It is cultivated worldwide as a fruit tree, and is the most widely grown " +
                "species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years " +
                "in Asia and Europe, and were brought to North America by European colonists. Apples have religious " +
                "and mythological significance in many cultures, including Norse, Greek and European Christian traditions."));
        products.add(new Product("PineApple", null,"Pineapple is a spiky-skinned, tropical, compound fruit with aromatic, sweet-sour juicy yellow flesh and a fibrous core. Miniature varieties have a tender, edible core."));
        products.add(new Product("Lime", null,"Limes are an important ingredient in Mexican, Indian, Latin American and South-East Asian cookery. T" +
                "hree main types are available: Tahitian, which is the largest, with the most acidic flavour; Mexican, slightly smaller, very aromatic, and with a particularly " +
                "bright green skin; and Key lime, which have a paler skin, a high juice content " +
                "and a strong flavour. Like lemons, limes are high in vitamin C."));
        products.add(new Product("Lemon", null,"Isn't it true that just a dash of lemon does wonders to elevate the flavours in a dish? " +
                "Lemon juice, when added to salads, curries, chutneys or drinks takes the preparation to its finality, a state of flawless, impeccable perfection. " +
                "When added to hot soups and warm broths, it transfers a woolly, " +
                "fuzzy feeling deep within. And what will our iced teas and summer drinks be without this citrusy delight?"));

//        p.setName("Bread");
//        products.add(p);
//
//        p.setName("Milk");
//        products.add(p);
//
//        p.setName("Sweet");
//        products.add(p);
//
//        p.setName("Tea");
//        products.add(p);
//
//        p.setName("Coffe");
//        products.add(p);
//
//        p.setName("Apple");
//        products.add(p);
//
//        p.setName("Pineapple");
//        products.add(p);


    }
}
