import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import HotSongsPage from "./screens/HotSongsPage";

const Stack = createStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Hot Songs" component={HotSongsPage} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
