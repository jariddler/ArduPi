/**
 * File generated by the ThingML IDE
 * /!\Do not edit this file/!\
 * In case of a bug in the generated code,
 * please submit an issue on our GitHub
 **/

package org.thingml.generated;

import org.thingml.java.*;
import org.thingml.java.ext.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Definition for type : WeatherStation
 **/
public class WeatherStation extends Component  {

//Attributes
private int WeatherStation_rate__var;
//Ports
private Port RemoteControlIn_port;
private Port RemoteControlOut_port;
private Port timer_port;
//Message types
private final TemperatureMessageType temperatureType = new TemperatureMessageType();
private final LightMessageType lightType = new LightMessageType();
private final ChangeDisplayMessageType changeDisplayType = new ChangeDisplayMessageType();
private final Timer_startMessageType timer_startType = new Timer_startMessageType();
private final Timer_cancelMessageType timer_cancelType = new Timer_cancelMessageType();
private final Timer_timeoutMessageType timer_timeoutType = new Timer_timeoutMessageType();
//Empty Constructor
public WeatherStation() {
super(3);
WeatherStation_rate__var = 2000;
}

//Constructor (all attributes)
public WeatherStation(String name, final int WeatherStation_rate__var) {
super(name, 3);
this.WeatherStation_rate__var = WeatherStation_rate__var;
}

//Getters and Setters for non readonly/final attributes
public int getWeatherStation_rate__var() {
return WeatherStation_rate__var;
}

public void setWeatherStation_rate__var(int WeatherStation_rate__var) {
this.WeatherStation_rate__var = WeatherStation_rate__var;
}

//Getters for Ports
public Port getRemoteControlIn_port() {
return RemoteControlIn_port;
}
public Port getRemoteControlOut_port() {
return RemoteControlOut_port;
}
public Port getTimer_port() {
return timer_port;
}
private CompositeState buildWeatherStation_SensorsDisplayImpl(){
final List<AtomicState> states_WeatherStation_SensorsDisplayImpl = new ArrayList<AtomicState>();
final AtomicState state_WeatherStation_SensorsDisplayImpl_Process = new AtomicState("Process")
{
@Override
public void onEntry() {
{
System.out.println("Weather station ready indeed");
send(timer_startType.instantiate(timer_port, (short) getWeatherStation_rate__var()), timer_port);
}
}

};
states_WeatherStation_SensorsDisplayImpl.add(state_WeatherStation_SensorsDisplayImpl_Process);
final List<Region> regions_WeatherStation_SensorsDisplayImpl = new ArrayList<Region>();
final List<Handler> transitions_WeatherStation_SensorsDisplayImpl = new ArrayList<Handler>();
transitions_WeatherStation_SensorsDisplayImpl.add(new InternalTransition("Handler_86444492",temperatureType, RemoteControlIn_port, state_WeatherStation_SensorsDisplayImpl_Process){
@Override
public void doExecute(final Event e) {
final TemperatureMessageType.TemperatureMessage ce = (TemperatureMessageType.TemperatureMessage) e;
{
System.out.println("Temperature is: " + ce.temp);
}
}

});
transitions_WeatherStation_SensorsDisplayImpl.add(new InternalTransition("Handler_901722632",lightType, RemoteControlIn_port, state_WeatherStation_SensorsDisplayImpl_Process){
@Override
public void doExecute(final Event e) {
final LightMessageType.LightMessage ce = (LightMessageType.LightMessage) e;
{
System.out.println("Light is: " + ce.light);
}
}

});
transitions_WeatherStation_SensorsDisplayImpl.add(new Transition("Handler_268451074",timer_timeoutType, timer_port, state_WeatherStation_SensorsDisplayImpl_Process, state_WeatherStation_SensorsDisplayImpl_Process){
@Override
public void doExecute(final Event e) {
final Timer_timeoutMessageType.Timer_timeoutMessage ce = (Timer_timeoutMessageType.Timer_timeoutMessage) e;
{
System.out.println("Changing Display on Arduino");
send(changeDisplayType.instantiate(RemoteControlOut_port), RemoteControlOut_port);
}
}

});
final CompositeState state_WeatherStation_SensorsDisplayImpl = new CompositeState("SensorsDisplayImpl", states_WeatherStation_SensorsDisplayImpl, state_WeatherStation_SensorsDisplayImpl_Process, transitions_WeatherStation_SensorsDisplayImpl, regions_WeatherStation_SensorsDisplayImpl, false){
@Override
public void onEntry() {
{
System.out.println("Weather station ready!");
}
super.onEntry();
}

}
;
return state_WeatherStation_SensorsDisplayImpl;
}

public Component buildBehavior() {
//Init ports
final List<EventType> inEvents_RemoteControlIn = new ArrayList<EventType>();
final List<EventType> outEvents_RemoteControlIn = new ArrayList<EventType>();
inEvents_RemoteControlIn.add(temperatureType);
inEvents_RemoteControlIn.add(lightType);
RemoteControlIn_port = new Port(PortType.PROVIDED, "RemoteControlIn", inEvents_RemoteControlIn, outEvents_RemoteControlIn, 0);
final List<EventType> inEvents_RemoteControlOut = new ArrayList<EventType>();
final List<EventType> outEvents_RemoteControlOut = new ArrayList<EventType>();
outEvents_RemoteControlOut.add(changeDisplayType);
RemoteControlOut_port = new Port(PortType.PROVIDED, "RemoteControlOut", inEvents_RemoteControlOut, outEvents_RemoteControlOut, 1);
final List<EventType> inEvents_timer = new ArrayList<EventType>();
final List<EventType> outEvents_timer = new ArrayList<EventType>();
inEvents_timer.add(timer_timeoutType);
outEvents_timer.add(timer_startType);
outEvents_timer.add(timer_cancelType);
timer_port = new Port(PortType.REQUIRED, "timer", inEvents_timer, outEvents_timer, 2);
//Init state machine
behavior = buildWeatherStation_SensorsDisplayImpl();
return this;
}

}

