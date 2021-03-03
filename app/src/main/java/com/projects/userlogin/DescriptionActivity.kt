package com.projects.userlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DescriptionActivity : AppCompatActivity() {
    lateinit var movieName:String
    lateinit var movieNameView: TextView
    lateinit var releaseDate:TextView
    lateinit var rating : TextView
    lateinit var genre:TextView
    lateinit var description:TextView
    lateinit var dataList:ArrayList<MovieDes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        movieNameView=findViewById(R.id.movieName)
        releaseDate=findViewById(R.id.releaseDate)
        genre=findViewById(R.id.genre)
        rating= findViewById(R.id.rating)
        description= findViewById(R.id.description)

        intent=getIntent()
        movieName= intent.getStringExtra("movieName").toString()

        setUpMovieList()

        for(aMovie in dataList)
        {
            if(movieName==aMovie.movieName)
            {
                movieNameView.text=aMovie.movieName
                releaseDate.text = aMovie.releaseDate
                genre.text = aMovie.genre
                rating.text=aMovie.rating
                description.text= aMovie.description
            }
        }
    }

    private fun setUpMovieList() {
        dataList=ArrayList<MovieDes>()
        dataList.add(MovieDes("Boss","Comedy,","16 October 2013","6/10","After his younger son falls prey to a corrupt police officer, an honest old man summons his estranged elder son to save the day."))
        dataList.add(MovieDes("Satyameva Jayate 2","Action","14 May 2021","6/10","Satyameva Jayate 2 is an upcoming Indian Hindi-language vigilante action film serving as a sequel to the 2018 film Satyameva Jayate and based on the fight against injustice & misuse of power."))
        dataList.add(MovieDes("Kaadan","Drama","26 March 2021","8/10","Kaadan ( transl. Forester) is an upcoming Indian Tamil-language drama film directed by Prabhu Solomon. It stars Rana Daggubati, Vishnu Vishal, Pulkit Samrat, Shriya Pilgaonkar and Zoya Hussain"))
        dataList.add(MovieDes("Padmaavat","Epic Drama","25 January 2018","6/10","Padmaavat is a 2018 Indian Hindi-language epic period drama film directed by Sanjay Leela Bhansali. Based on the epic poem of the same name by Malik Muhammad Jayasi, it stars Deepika Padukone as Rani Padmavati, a Rajput queen known for her beauty, wife of Maharawal Ratan Singh, played by Shahid Kapoor."))
        dataList.add(MovieDes("Krrish 3","Action","18 September 2013","8/10","Krrish 3 is a 2013 Indian Hindi-language superhero film produced and directed by Rakesh Roshan, and written by Honey Irani and Robin Bhatt. It is the third film in the Krrish series, following Koi... Mil Gaya (2003) and Krrish (2006)"))
        dataList.add(MovieDes("Dhoom 3","Thriller","20 December 2013","8/10","Dhoom 3 is an action thriller written and directed by Vijay Krishna Acharya, who has also written Dhoom and Dhoom 2."))
        dataList.add(MovieDes("Durgamati","Horror","11 December 2020","4/10","Durgamati is a 2020 Indian Hindi-language horror thriller film directed by G. Ashok which is a remake of his own Telugu-Tamil bilingual film Bhaagamathie (2018). It starres Bhumi Pednekar as an IAS officer, with Arshad Warsi, Jisshu Sengupta and Mahie Gill playing supporting roles."))
        dataList.add(MovieDes("Ludo","Comedy","12 November 2020","8/10","Ludo starts with two people contemplating life and death and they decide to play ludo. The game they play correlates to the lives of Sattu Bhaiya, Akash, Alu and Bittu. Sattu Bhaiya is a notorious gangster who has to settle old scores with Bittu, who was once his right-hand man."))
        dataList.add(MovieDes("Chhalaang","Comedy","13 November 2020","6/10","In Chhalaang, Hansal and Rajkummar attempt something more mainstream. They tell the uplifting story of a PT teacher in small-town Haryana, who finds his purpose in life through coaching the weakest kids in the school into a winning team. I suspect this conventional narrative went against their DNA"))
        dataList.add(MovieDes("Laxmii","Horror Comedy","9 November 2020","4/10","Laxmii is a 2020 Indian Hindi-language comedy horror film written and directed by Raghava Lawrence, marking his directorial debut in Hindi film industry."))
        dataList.add(MovieDes("Aadhaar","Drama","5 February 2021","4/10","Aadhaar revolves around Pharsua, a villager who is the first to enroll for Aadhaar card in his village. Due to a premonition concerning his wife`s health, he decides to get his number changed"))
        dataList.add(MovieDes("Shakeela","Biography","25 December 2020","2/10","Shakeela is a 2020 an Indian biographical film written and directed by Indrajit Lankesh. The film stars Richa Chadda as the eponymous adult star of 1990s from Chennai, Tamil Nadu who acted in Tamil, Telugu, Malayalam and Kannada-language adult films, with Pankaj Tripathi and Rajeev Pillai in supporting roles."))
        dataList.add(MovieDes("Insidious","Horror, Mystery, Thr)iller ","1 April 2011","6.8/10","A family looks to prevent evil spirits from trapping their comatose child in a realm called The Further."))
        dataList.add(MovieDes("Joker","Crime, Drama, Thriller ","4 October 2019"," 8.4/10","In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker."))
        dataList.add(MovieDes("Inception"," Action, Adventure, Sci-Fi ","16 July 2010","8. 8/10","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O."))
        dataList.add(MovieDes("Interstellar","Adventure, Drama, Sci-Fi "," 7 November 2014","8. 6/10","A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."))
        dataList.add(MovieDes("Tom and Jerry","Animation, Adventure, Comedy "," 26 February 2021 "," 5.3/10","Adaptation of the classic Hanna-Barbera property, which reveals how Tom and Jerry first meet and form their rivalry."))
        dataList.add(MovieDes("Tenet","Action, Sci-Fi, Thriller ","3 September 2020 ","7.5/10","Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time."))
        dataList.add(MovieDes("Wonder Woman 1984","Action, Adventure, Fantasy ","25 December 2 020 ","5.4/10","Diana must contend with a work colleague and businessman, whose desire for extreme wealth sends the world down a path of destruction, after an ancient artifact that grants wishes goes missing."))
        dataList.add(MovieDes("Avengers: Endgame","Action, Adventure, Drama ","26 April 2019 ","8.4/10","After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe."))
        dataList.add(MovieDes("1917 ","Horror, Mystery, Thriller,","10 January 2020 ","8.3/10","April 6th, 1917. As a regiment assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap."))
        dataList.add(MovieDes("Gladiator","Action, Adventure, Drama","5 May 2000 ","8.5/10","A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery."))
    }
}