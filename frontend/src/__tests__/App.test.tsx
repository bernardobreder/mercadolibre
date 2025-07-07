import { render, screen } from "@testing-library/react";
import App from "../App";
import { http, HttpResponse } from "msw";
import { setupServer } from "msw/node";

// Mock do backend
const server = setupServer(
  http.get("http://localhost:8080/api/produtos/1", () => {
    return HttpResponse.json({
      nome: "Samsung Galaxy A55",
      preco: 439,
      descricao: "O Samsung A55 é rápido, moderno e bonito.",
      specs: {
        Tela: '6.6"',
        Memória: "256 GB",
        "Câmera Principal": "50 MP",
        Frontal: "32 MP",
        NFC: "Sim",
      },
    });
  })
);

beforeAll(() => server.listen());
afterEach(() => server.resetHandlers());
afterAll(() => server.close());

describe("App", () => {
  it("deve renderizar o conteúdo após carregar dados do backend", async () => {
    render(<App />);
    screen.debug();
    expect(await screen.findByText("Samsung Galaxy A55")).toBeInTheDocument();
    expect(screen.getByText("R$ 439")).toBeInTheDocument();
    expect(
      screen.getByText("O Samsung A55 é rápido, moderno e bonito.")
    ).toBeInTheDocument();

    expect(
      screen.getByText((_, el) => el?.textContent?.includes('Tela: 6.6"'))
    ).toBeInTheDocument();

    expect(
      screen.getByText((_, el) => el?.textContent?.includes("Memória: 256 GB"))
    ).toBeInTheDocument();

    expect(
      screen.getByText((_, el) =>
        el?.textContent?.includes("Câmera Principal: 50 MP")
      )
    ).toBeInTheDocument();
  });
});
