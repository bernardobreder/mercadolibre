import { render, screen } from "@testing-library/react";
import ProductStock from "../ProductStock";

describe("ProductStock", () => {
  it("deve mostrar o estoque disponível", () => {
    render(<ProductStock stock={7} />);
    expect(screen.getByText(/estoque disponível: 7/i)).toBeInTheDocument();
  });
});
