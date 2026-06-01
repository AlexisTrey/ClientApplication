package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.ClientModel;
import co.edu.uptc.view.ClientFrame;

public class Runner {

    private ModelInterface model;
    private ViewInterface view;
    private PresenterInterface presenter;

    public void start() {
        makeMvp();
        view.start();
    }

    private void makeMvp() {
        model = new ClientModel();
        presenter = new ClientPresenter();
        view = ClientFrame.getInstance();
        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
    }
}
