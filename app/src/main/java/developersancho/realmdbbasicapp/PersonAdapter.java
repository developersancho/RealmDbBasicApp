package developersancho.realmdbbasicapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private Context context;
    private List<Person> personList;
    private IClickListener clickListener;

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public TextView personName, personSurname, personDepartment, personAge, personOptionMenu;

        public PersonViewHolder(View view) {
            super(view);
            personName = (TextView) view.findViewById(R.id.personName);
            personSurname = (TextView) view.findViewById(R.id.personSurname);
            personDepartment = (TextView) view.findViewById(R.id.personDepartment);
            personAge = (TextView) view.findViewById(R.id.personAge);
            personOptionMenu = (TextView) view.findViewById(R.id.textViewOptions);

            personOptionMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onMenuClick(v, getAdapterPosition());
                }
            });

        }
    }

    public PersonAdapter(Context mContext, List<Person> personList, IClickListener clickListener) {
        this.context = mContext;
        this.personList = personList;
        this.clickListener = clickListener;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recylerview_item, parent, false);

        return new PersonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder holder, int position) {
        Person personTable = personList.get(position);
        holder.personName.setText(personTable.getName());
        holder.personSurname.setText(personTable.getSurname());
        holder.personDepartment.setText(personTable.getDepartment());
        holder.personAge.setText(String.valueOf(personTable.getAge()));

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}
