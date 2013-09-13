package com.netflix.simianarmy.chaos;

import com.netflix.simianarmy.CloudClient;

/**
 * Shuts down the instance using the cloud instance-termination API.
 *
 * This is the classic chaos-monkey strategy.
 */
public class ShutdownInstanceChaosType extends ChaosType {
    /**
     * Singleton instance of this chaos type.
     */
    public static final ChaosType INSTANCE = new ShutdownInstanceChaosType();

    /**
     * (Protected) singleton constructor.
     */
    protected ShutdownInstanceChaosType() {
        super("ShutdownInstance");
    }

    /**
     * Shuts down the instance.
     */
    @Override
    public void apply(CloudClient cloudClient, String instanceId) {
        cloudClient.terminateInstance(instanceId);
    }

}