using System;
using System.Collections.Generic;

namespace Aircompany.Planes {
    public class PassengerPlane : Plane {

        public int planePassengerCapacity;
        public PassengerPlane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity)
            : base(model, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            planePassengerCapacity = passengersCapacity;
        }

        public int GetPassengersCapacity() {
            return planePassengerCapacity;
        }

        public override string ToString() {
            return base.ToString().Replace("}",
                ", passengersCapacity=" + planePassengerCapacity + '}');
        }

        public override bool Equals(object obj) {
            return obj is PassengerPlane plane &&
                base.Equals(obj) &&
                planePassengerCapacity == plane.planePassengerCapacity;
        }

        public override int GetHashCode() {
            var hashCode = 751774561;
            hashCode *= base.GetHashCode();
            hashCode *= 1521134295 + planePassengerCapacity.GetHashCode();
            return hashCode;
        }
    }
}
