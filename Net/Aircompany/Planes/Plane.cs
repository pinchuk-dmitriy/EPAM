using System.Collections.Generic;

namespace Aircompany.Planes {
    public abstract class Plane {

        public string modelPlane;
        public int maxSpeedPlane;
        public int maxFlightDistancePlane;
        public int maxLoadCapacityPlane;
        public Plane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
            modelPlane = model;
            maxSpeedPlane = maxSpeed;
            maxFlightDistancePlane = maxFlightDistance;
            maxLoadCapacityPlane = maxLoadCapacity;
        }

        public string GetModelPlane() {
            return modelPlane;
        }

        public int GetMaxSpeed() {
            return maxSpeedPlane;
        }

        public int GetMaxFlightDistance() {
            return maxFlightDistancePlane;
        }

        public int GetMaxLoadCapacity() {
            return maxLoadCapacityPlane;
        }

        public override string ToString() {
            return "Plane{" +
                "model='" + modelPlane + '\'' +
                ", maxSpeed=" + maxSpeedPlane +
                ", maxFlightDistance=" + maxFlightDistancePlane +
                ", maxLoadCapacity=" + maxLoadCapacityPlane +
                '}';
        }

        public override bool Equals(object obj) {
            var plane = obj as Plane;
            return plane != null &&
                modelPlane == plane.modelPlane &&
                maxSpeedPlane == plane.maxSpeedPlane &&
                maxFlightDistancePlane == plane.maxFlightDistancePlane &&
                maxLoadCapacityPlane == plane.maxLoadCapacityPlane;
        }

        public override int GetHashCode() {
            var hashCode = 1043886837;
            hashCode *= 1521134295 + EqualityComparer<string>.Default.GetHashCode(modelPlane);
            hashCode *= 1521134295 + maxSpeedPlane.GetHashCode();
            hashCode *= 1521134295 + maxFlightDistancePlane.GetHashCode();
            hashCode *= 1521134295 + maxLoadCapacityPlane.GetHashCode();
            return hashCode;
        }        
    }
}
