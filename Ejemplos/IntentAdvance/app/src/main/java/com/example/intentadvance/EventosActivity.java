package com.example.intentadvance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.intentadvance.Helpers.EventosAdapter;
import com.example.intentadvance.Models.Eventos;

import java.util.ArrayList;
import java.util.List;

public class EventosActivity extends AppCompatActivity {

    ListView lstEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        Bundle b = getIntent().getExtras();
        InicializarControles();

        if (b != null){
            LoadListviewBundle(b);
        }else{
            LoadListview();
        }
    }

    private void InicializarControles(){
        lstEventos = (ListView)findViewById(R.id.lstEventos);

    }

    private void LoadListview() {
        EventosAdapter adapter = new EventosAdapter(getApplicationContext(),this.ObtenerEventos());
        lstEventos.setAdapter(adapter);
    }

    private void LoadListviewBundle(Bundle b) {

        List<Eventos> eventos = new ArrayList<>();
        eventos.add(new Eventos(Integer.parseInt(b.getString("dia")),b.getString("dial"),b.getString("mes"),b.getString("titulo"),b.getString("contenido"),b.getString("enlace")));

        EventosAdapter adapter = new EventosAdapter(getApplicationContext(),eventos);
        lstEventos.setAdapter(adapter);
    }

    private List<Eventos> ObtenerEventos(){

        List<Eventos> eventos = new ArrayList<>();
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","LOREM IPSUM","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","LOREM IPSUM","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","LOREM IPSUM","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","LOREM IPSUM","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","LOREM IPSUM","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","LOREM IPSUM","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","LOREM IPSUM","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"","Ver mas"));
        eventos.add(new Eventos(6,"Jueves","Octubre","Programacion Avanzada Movil","LOREM IPSUM","Ver mas"));

        return eventos;
    }

}