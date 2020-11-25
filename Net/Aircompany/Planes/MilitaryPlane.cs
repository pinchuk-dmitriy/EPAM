using System.Collections.Generic;
using Aircompany.Models;

namespace Aircompany.Planes {
    public class MilitaryPlane : Plane {

        public MilitaryType militaryTypePlane;
        public MilitaryPlane(string modelPlane, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType typePlane)
            : base(modelPlane, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            militaryTypePlane = typePlane;
        }

        public MilitaryType GetPlaneType() {
            return militaryTypePlane;
        }

        public override string ToString() {
            return base.ToString().Replace("}",
                ", type=" + militaryTypePlane + '}');
        }

        public override bool Equals(object obj) {
            return obj is MilitaryPlane plane &&
                base.Equals(obj) &&
                militaryTypePlane == plane.militaryTypePlane;
        }

        public override int GetHashCode() {
            var hashCode = 1701194404;
            hashCode *= base.GetHashCode();
            hashCode *= 1521134295 + militaryTypePlane.GetHashCode();
            return hashCode;
        }
    }
}
