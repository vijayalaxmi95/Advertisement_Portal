import "@/styles/globals.css";
import type { AppProps } from "next/app";
import Layout from "./Components/Layout";
import { AppContextProvider } from "./Components/AppContext";

export default function App({ Component, pageProps }: any) {
  // Use the layout defined at the page level, if available
  if (Component.getLayout) {
    const getLayout = Component.getLayout || ((page: any) => page);
    return getLayout(<Component {...pageProps} />);
  } else {
    return (
      <AppContextProvider>
        <Layout>
          <Component {...pageProps} />
        </Layout>
      </AppContextProvider>
    );
  }
}
