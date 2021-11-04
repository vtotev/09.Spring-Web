package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> getAllRoutesView();
}
