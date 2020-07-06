package Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.prueba.R;

import java.util.ArrayList;

import adapter.PictureAdapterRecyclerView;
import model.Picture;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView picturesRecycler  = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://i0.wp.com/www.acimedellin.org/wp-content/uploads/2019/11/medellin-newsweek-1.jpg?fit=750%2C387&ssl=1", "Medellín Centro", "2 horas", "Puntuación: 5"));
        pictures.add(new Picture("https://q-xx.bstatic.com/xdata/images/hotel/max500/110761600.jpg?k=c45e531a93c91ef5764ef7ea47617b93b07adc1a3bc79359f2a5c3f5fc12c06d&o=", "Poblado", "30 minutos", "Puntuación: 3,8"));
        pictures.add(new Picture("https://www.parqueexplora.org/sites/default/files/vEP5.png", "Parque Explora", "4 horas", "Puntuación: 4,7"));
        pictures.add(new Picture("https://www.monoviajero.com/wp-content/uploads/2019/06/guatape-pe%C3%B1ol-como-visitar-desde-medellin-6.jpg", "Guatapé", "6 horas", "Puntuación: 4,4"));
        pictures.add(new Picture("https://www.arquitecturayempresa.es/sites/default/files/content/orquideorama_bajo_cubierta1.jpg", "Jardín Botánico", "3 horas", "Puntuación: 4,5"));
        return pictures;
    }



}