using System;
using System.Collections.Generic;
using System.Linq;
using Aircompany.Models;
using Aircompany.Planes;

namespace Aircompany {
    public class Airport {

        public List<Plane> Planes;
        public Airport(IEnumerable<Plane> planes) {
            Planes = planes.ToList();
        }

        public IEnumerable<PassengerPlane> GetPassengersPlanes() {
            return Planes.Where(plane => plane.GetType() == typeof(PassengerPlane)).Cast<PassengerPlane>();
        }

        public IEnumerable<MilitaryPlane> GetMilitaryPlanes() {
            return Planes.Where(plane => plane.GetType() == typeof(MilitaryPlane)).Cast<MilitaryPlane>();
        }

        public PassengerPlane GetPassengerPlaneWithMaxPassengersCapacity() {
            return GetPassengersPlanes().Aggregate((firstPlane, secondPlane) => 
                firstPlane.GetPassengersCapacity() > secondPlane.GetPassengersCapacity() ? firstPlane : secondPlane);             
        }

        public IEnumerable<MilitaryPlane> GetTransportMilitaryPlanes() {
            return GetMilitaryPlanes().Where(militaryPlane => militaryPlane.GetPlaneType() == MilitaryType.Transport).Cast<MilitaryPlane>();
        }

        public Airport SortByMaxDistance() {
            return new Airport(Planes.OrderBy(sortedPlane => sortedPlane.GetMaxFlightDistance()));
        }

        public Airport SortByMaxSpeed() {
            return new Airport(Planes.OrderBy(sortedPlane => sortedPlane.GetMaxSpeed()));
        }

        public Airport SortByMaxLoadCapacity() {
            return new Airport(Planes.OrderBy(sortedPlane => sortedPlane.GetMaxLoadCapacity()));
        }

        public IEnumerable<Plane> GetPlanes() {
            return Planes;
        }
        public override string ToString() {
            return "Airport{" +
                "planes=" + string.Join(", ", Planes.Select(x => x.GetModelPlane())) +
                '}';
        }
    }
}
