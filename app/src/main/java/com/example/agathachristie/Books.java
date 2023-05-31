package com.example.agathachristie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Books extends AppCompatActivity {

    GridView gridView;
    String [] books = {"I can make this promise ", "Acts of love and war" , "An orphans war" ,
                       "Remember me","Remember Love" ,"Address"};
    int [] books_images = {R.drawable.book1 , R.drawable.book2 , R.drawable.book3 ,
                           R.drawable.book4 , R.drawable.book5 , R.drawable.book6};

    String book1 = "In her debut middle grade novel—inspired by her family’s history—Christine Day tells the story of a girl who uncovers her family’s secrets—and finds her own Native American identity.\n" +
            "\n" +
            "All her life, Edie has known that her mom was adopted by a white couple. So, no matter how curious she might be about her Native American heritage, Edie is sure her family doesn’t have any answers.\n" +
            "\n" +
            "Until the day when she and her friends discover a box hidden in the attic—a box full of letters signed “Love, Edith,” and photos of a woman who looks just like her.\n" +
            "\n" +
            "Suddenly, Edie has a flurry of new questions about this woman who shares her name. Could she belong to the Native family that Edie never knew about? But if her mom and dad have kept this secret from her all her life, how can she trust them to tell her the truth now?";

    String book2 = "A remarkable story of love and sacrifice centred on three young English volunteers in the bloody Spanish Civil War, from the author of The Prisoner's Wife.\n" +
            "\n" +
            "1936. Civil war is tearing Spain apart, and the world is on the brink of chaos... \n" +
            " \n" +
            "Twenty-one-year-old Lucy is frustrated with her constrained life in Hertfordshire, teaching and keeping house for her domineering father. But she is happy to be living next door to Tom and Jamie, two brothers she has known since childhood, and whom she loves equally.\n" +
            " \n" +
            "But everyone's lives are turned upside down when Tom, the younger, decides to join the Republican cause in the bloody war in Spain. His older, fervently Catholic brother Jamie soon follows--but as a reporter for the opposing forces that support General Franco in keeping Spain rigidly authoritarian, with the help of both Hitler and Mussolini.";

    String book3 = "Amsterdam, 1941.\n" +
            "\n" +
            "German forces have invaded Amsterdam. As the tension in the city increases, the Dutch Resistance is born.\n" +
            "\n" +
            "Tormented by what is happening in his city, Christiaan joins the Resistance. He risks everything to shield the oppressed and fight for the freedom of his beloved nation.\n" +
            "\n" +
            "His brother—Floris—is ruthless and driven to succeed. Promoted to the Bureau of Jewish Affairs, he becomes instrumental in hunting Jews to transport them to the Nazi death camps.\n" +
            "\n" +
            "Unable to tolerate Floris' actions, his wife—Nora—defies him by secretly joining the Resistance. She bravely risks her life to save orphans from the terror of the transport train and the horrifying fate that awaits them. All while fearfully deceiving the enemy with whom she lives.\n" +
            "\n" +
            "These three find themselves in the middle of a maelstrom that will change the course of human history. As ambition, fear, and desperation collide, no one is safe.";

    String book4 = "Amid the shadows of war, one family faces an impossible choice that will change their lives forever. From bestseller Mario Escobar comes a 20th-century historical novel of sacrifice and resilience inspired by Spain’s famed Children of Morelia and the true events that shaped their lives.\n" +
            "\n" +
            "Madrid, 1934. Though the Spanish Civil War has not yet begun, the streets of Madrid have become dangerous for thirteen-year-old Marco Alcalde and his two younger sisters. Marco’s parents align themselves against the new fascist regime, unaware that their choice will endanger the entire family—nor do they predict the violence that is to come.\n" +
            "\n" +
            "In a desperate bid for safety, the Alcaldes join many other Spanish families in making an impossible choice to send their unaccompanied children across the ocean to the city of Morelia, Mexico—a place they’ve never seen or imagined, but whose government promises their children protection. Young Marco promises to look after his sisters in Mexico until their family can be reunited in Spain, but a harrowing journey ensues.";

    String book5 = "“One of the best.” – Julia Quinn\n" +
            "\n" +
            "The beloved queen of Regency romance is back with a brand-new story perfect for fans of Bridgerton.\n" +
            "\n" +
            "The handsome and charismatic Earl of Stratton, Caleb Ware, has been exposed to the ton for his clandestine affairs—by his own son.\n" +
            " \n" +
            "As a child, Devlin Ware thought his family stood for all that was right and good in the world. They were kind, gracious, and shared the beauty of Ravenswood, their grand country estate, by hosting lavish parties for the entire countryside. But at twenty-two, he discovered his whole world was an elaborate illusion, and when Devlin publicly called his family to account for it, he was exiled as a traitor.";

    String book6 = "After a failed apprenticeship, working her way up to head housekeeper of a posh London hotel is more than Sara Smythe ever thought she’d make of herself. But when a chance encounter with Theodore Camden, one of the architects of the grand New York apartment house The Dakota, leads to a job offer, her world is suddenly awash in possibility—no mean feat for a servant in 1884. The opportunity to move to America, where a person can rise above one’s station. The opportunity to be the female manager of The Dakota, which promises to be the greatest apartment house in the world. And the opportunity to see more of Theo, who understands Sara like no one else...and is living in The Dakota with his wife and three young children.";

    String [] Book_details ={book1 , book2 , book3 , book4 , book5 , book6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        gridView = findViewById(R.id.gridView);
        customAdapter customAdapter = new customAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext() , Activity_Books_items.class);
                intent.putExtra("name" , books[i] );
                intent.putExtra("image" , books_images[i] );
                intent.putExtra("details" ,Book_details[i] );
                startActivity(intent);
            }
        });

    }

    private class customAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return books_images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.rows_data , null);
            TextView name = view1.findViewById(R.id.books);
            ImageView imageView = view1.findViewById(R.id.Books_images);

            name.setText(books[i]);
            imageView.setImageResource(books_images[i]);

            return view1;
        }
    }

}