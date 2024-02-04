package com.casestudy.amadeus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        if (flightRepository.existsById(id)) {
            flight.setId(id);
            return flightRepository.save(flight);
        }
        return null; // Flight with given ID not found
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> searchFlights(Airport departureAirport, Airport arrivalAirport, Date departureDate, Date returnDate) {
        if (returnDate == null) {
            return searchOneWayFlights(departureAirport, arrivalAirport, departureDate);
        } else {
            return searchRoundTripFlights(departureAirport, arrivalAirport, departureDate, returnDate);
        }
    }

    public List<Flight> searchOneWayFlights(Airport departureAirport, Airport arrivalAirport, Date departureDate) {
        // Implement the logic for searching one-way flights based on the given criteria
        // You may use the FlightRepository or any other mechanism to fetch data from the database
        return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureTime(departureAirport, arrivalAirport, departureDate);
    }

    public List<Flight> searchRoundTripFlights(Airport departureAirport, Airport arrivalAirport, Date departureDate, Date returnDate) {
        // Implement the logic for searching round-trip flights based on the given criteria
        // You may use the FlightRepository or any other mechanism to fetch data from the database
        return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureTimeAndReturnTime(departureAirport, arrivalAirport, departureDate, returnDate);
    }
}

