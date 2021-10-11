package edu.temple.lab_4_multiple_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.Lab_4_Multiple_Activites.ImageAdapter
import edu.temple.Lab_4_Multiple_Activites.ImageObject

class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize the list of objects
        val items = setDataInList()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        //change the title of the actionbar to be unique
        getSupportActionBar()!!.setTitle("Dynamic Reponse Branch")

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            //pull off all values to be sent to the response activity
            val name = items.get(itemPosition).name
            val image = items.get(itemPosition).resourceId
            val description = items.get(itemPosition).description
            //create the intent of the second activity to be triggered
            val intent = Intent(this, DisplayActivity::class.java)

            //add all values of chosen image to the intent
            intent.putExtra("Name", name)
            intent.putExtra("Image", image)
            intent.putExtra("Description",description)
            //start the response activity
            startActivity(intent)


        }

        //apply the adapter and layout manager to the recyclerView
        //Add in item Decoration to make a divider that seperates the photos in the grid verically(Horizontal line)
        recyclerView.apply {
            recyclerView.adapter = ImageAdapter(items, onClickListener)
            recyclerView.layoutManager = GridLayoutManager(this.context, 3)
            var itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            itemDecoration.setDrawable(getDrawable(R.drawable.divider)!!)
            recyclerView.addItemDecoration(itemDecoration)

        }

    }

    // Test data
    private fun setDataInList(): ArrayList<ImageObject> {
        var items: ArrayList<ImageObject> = ArrayList()

        items.add(ImageObject(R.drawable.australia, "The Sydney Opera House is a multi-venue performing " +
                "arts centre on Sydney Harbour located in Sydney, New South Wales, Australia. It is one of the " +
                "20th century's most famous and distinctive buildings.","Australia"))
        items.add(ImageObject(R.drawable.brazil,"Christ the Redeemer " +
                " is an Art Deco statue of Jesus Christ in Rio de Janeiro, Brazil, created by French sculptor Paul " +
                "Landowski and built by Brazilian engineer Heitor da Silva Costa, in collaboration with French engineer " +
                "Albert Caquot. Romanian sculptor Gheorghe Leonida fashioned the face. Constructed between 1922 and 1931, " +
                "the statue is 30 metres (98 ft) high", "Brazil"))
        items.add(ImageObject(R.drawable.china,"The Leshan Giant Buddha is a 71-metre (233 ft) tall stone " +
                "statue, built between 713 and 803 (during the Tang dynasty. It is carved out of a cliff face of " +
                "Cretaceous red bed sandstones that lies at the confluence of the Min River and Dadu River in the " +
                "southern part of Sichuan province in China, near the city of Leshan.", "China"))
        items.add(ImageObject(R.drawable.dubai,"The Burj Khalifa, known as the Burj Dubai prior to its inauguration in 2010, " +
                "is a skyscraper in Dubai, United Arab Emirates. With a total height of 829.8 m (2,722 ft, just " +
                "over half a mile) and a roof height (excluding antenna, but including a 244 m spire) of 828 " +
                "m (2,717 ft), the Burj Khalifa has been the tallest structure and building in the world since its " +
                "topping out in 2009", "Dubai"))
        items.add(ImageObject(R.drawable.egypt,"The Great Pyramid of Giza (also known as the Pyramid of Khufu or the " +
                "Pyramid of Cheops) is the oldest and largest of the pyramids in the Giza pyramid complex bordering " +
                "present-day Giza in Greater Cairo, Egypt. It is the oldest of the Seven Wonders of the Ancient World, " +
                "and the only one to remain largely intact.", "Egypt"))
        items.add(ImageObject(R.drawable.france,"The Eiffel Tower is a wrought-iron lattice tower on the" +
                " Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, whose company " +
                "designed and built the tower.", "France"))
        items.add(ImageObject(R.drawable.india,"The Taj Mahal is an ivory-white marble mausoleum on the " +
                "right bank of the river Yamuna in the Indian city of Agra. It was commissioned in 1632 by the " +
                "Mughal emperor Shah Jahan (reigned from 1628 to 1658) to house the tomb of his favourite wife, " +
                "Mumtaz Mahal; it also houses the tomb of Shah Jahan himself.","India"))
        items.add(ImageObject(R.drawable.italy,"The Leaning Tower of Pisa is the campanile, or freestanding bell " +
                "tower, of the cathedral of the Italian city of Pisa, known worldwide for its nearly four-degree lean, " +
                "the result of an unstable foundation. The tower is situated behind the Pisa Cathedral and is the " +
                "third-oldest structure in the city's Cathedral Square (Piazza del Duomo)", "Italy"))
        items.add(ImageObject(R.drawable.new_york,"One World Trade Center (also known as One World " +
                "Trade, One WTC, and formerly Freedom Tower) is the main building of the rebuilt World " +
                "Trade Center complex in Lower Manhattan, New York City. One WTC is the tallest building in " +
                "the United States, the tallest building in the Western Hemisphere, and the sixth-tallest in " +
                "the world.","New York"))
        items.add(ImageObject(R.drawable.rome,"The Colosseum is an oval amphitheatre in the centre of the city of Rome, " +
                "Italy, just east of the Roman Forum. It is the largest ancient amphitheatre ever built, and is " +
                "still the largest standing amphitheatre in the world today, despite its age. Construction began " +
                "under the emperor Vespasian (r. 69–79 AD) in 72 and was completed in 80 AD under his successor " +
                "and heir, Titus (r. 79–81).", "Rome"))
        items.add(ImageObject(R.drawable.russia,"The Cathedral of Vasily the Blessed " +
                "commonly known as Saint Basil's Cathedral, is an Orthodox church in Red Square of Moscow, and " +
                "is one of the most popular cultural symbols of Russia. The building, now a museum, is officially " +
                "known as the Cathedral of the Intercession of the Most Holy Theotokos on the Moat, or Pokrovsky " +
                "Cathedral.", "Russia"))
        return items
    }

}