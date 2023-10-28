import "./App.css"
import "@fontsource/montserrat"; // Defaults to weight 400
import "@fontsource/montserrat/400.css"; // Specify weight
import "@fontsource/montserrat/400-italic.css";

function App() {
  return (
    <div className="schedule-container">
            <div className="time-column">
                <div className="time">10:00 AM</div>
                <div className="time">11:00 AM</div>
                <div className="time">12:00 PM</div> 
                <div className="time">01:00 PM</div>
                <div className="time">02:00 PM</div>
                <div className="time">03:00 PM</div>
                <div className="time">04:00 PM</div>
                <div className="time">05:00 PM</div>
                <div className="time">06:00 PM</div>
                <div className="time">07:00 PM</div>
                <div className="time">08:00 PM</div>
                <div className="time">09:00 PM</div>
            </div>
            
            <div className="room-column">
                <div className="room-title">Meeting Room</div>
                <div className="booking">Daily Meeting</div>
                <div className="booking unavailable">Brainstorming</div>
                {/* ... Add other bookings here ... */}
            </div>
            
            <div className="room-column">
                <div className="room-title">Co-working Space</div>
                <div className="booking unavailable">Unavailable</div>
                {/* ... Add other bookings here ... */}
            </div>
            <div className="room-column">
                <div className="room-title">War Room</div>
                <div className="booking unavailable">Brainstorming</div>
                <div className="booking">Customer Suport</div>
                <div className="booking">Customer Suport</div>
            </div>
            <div className="room-column">
                <div className="room-title">Ideation Lab</div>
                <div className="booking unavailable">Brainstorming</div>
                {/* ... Add other bookings here ... */}
            </div>
            <div className="room-column">
                <div className="room-title">Conference Room</div>
                <div className="booking">Scrum Meeting</div>
                <div className="booking unavailable">Brainstorming</div>
                {/* ... Add other bookings here ... */}
            </div>
        </div>
  );
}

export default App;
