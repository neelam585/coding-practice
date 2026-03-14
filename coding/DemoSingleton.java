public class DemoSingleton {

    // Declare the static variable for the Singleton instance
    private static DemoSingleton demoSingleton;

    // Private constructor to prevent instantiation from outside
    private DemoSingleton() {

    }

    // Public method to provide access to the Singleton instance
    public static DemoSingleton getDemoSingleton() {
        // Check if the instance is already created
        if (demoSingleton == null) {
            demoSingleton = new DemoSingleton();  // Assign to the static field
        }
        return demoSingleton;  // Return the Singleton instance
    }
}
