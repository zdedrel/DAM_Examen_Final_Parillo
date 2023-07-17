package com.example.dam_examen_final_parillo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
//import com.example.dam_examen_final_parillo.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private NotasInteractionListener mListener;
    private List<Nota> notaList;
    private MyNotaRecyclerViewAdapter adapterNotas;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager( mColumnCount, StaggeredGridLayoutManager.VERTICAL));
            }
            notaList = new ArrayList<>();

            notaList.add(new Nota("Trabajo Académico:","Las notas del trabajo académico fueron revisadas e ingresadas el día 16 de Julio.", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Examen Final:","Estudiar para el Examen Final: Caso: Notas Listas, es una réplica de la UC4", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Resultado de Examen Final:","La Revisión del examen final se revisarán durante la sesión de clases y el resultado será publicado en los próximos días, especificamente: 24/07/23 - 31/07/23  Examen final", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Examen Sustitutorio:","Examen Sustitutorio planificado para el día 24 de julio del 2023. Asistir puntualmente a todos los que se van a presentar.", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Examen Final:","Desfiles militares, ferias gastronómicas y recorridos turísticos se abren para celebrar en este año 2023. ¡Felíz día del Perú!   ", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Fiestas Patrias:","Aprecio mucho su amistad, su participación en las sesiones de clases, cada ciclo es una nueva experiencia, deseo que sigan estudiando. Muchas Felicidades. Nos vemos el 2023 - II", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Despedida de Ciclo:","Todas las distintas capacidades que el hombre posee de la mente, del alma y del cuerpo le fueron dadas por Dios para que las dedique a alcanzar el más alto grado de excelencia posible. Toda facultad y todo atributo con que el Creador nos haya dotado deben emplearse para su gloria y para el ennoblecimiento de nuestros semejantes. Y en este empleo se halla la ocupación más pura, más noble y más feliz.", true, android.R.color.holo_blue_light));

            adapterNotas = new MyNotaRecyclerViewAdapter(notaList, mListener);
            recyclerView.setAdapter(adapterNotas);

            //recyclerView.setAdapter(new MyNotaRecyclerViewAdapter(PlaceholderContent.ITEMS));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NotasInteractionListener){
            mListener = (NotasInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "Debe implementarse NotasInteractionListener");
        }
    }

}