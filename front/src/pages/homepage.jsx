import Navbar from "../components/navbar.jsx";
import Sidebar from "../components/sidebar.jsx";
import HomePageMiddle from "../components/homePageMiddle.jsx";

function Homepage() {
    return(
        <div>
            <Navbar />
            <Sidebar />
            <HomePageMiddle />
        </div>
    );
}

export default Homepage;