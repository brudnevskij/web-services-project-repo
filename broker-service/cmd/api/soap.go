package main

import (
	"encoding/xml"
	"time"

	"github.com/hooklift/gowsdl/soap"
)

// against "unused imports"
var _ time.Time
var _ xml.Name

type GetCurrency struct {
	XMLName xml.Name `xml:"dude getCurrency"`

	CurrencyName string `xml:"currencyName,omitempty"`
}

type GetCurrencyResponse struct {
	XMLName xml.Name `xml:"dude getCurrencyResponse"`

	GetCurrencyResult float64 `xml:"getCurrencyResult,omitempty"`
}

type Application interface {
	GetCurrency(request *GetCurrency) (*GetCurrencyResponse, error)
}

type application struct {
	client *soap.Client
}

func NewApplication(client *soap.Client) Application {
	return &application{
		client: client,
	}
}

func (service *application) GetCurrency(request *GetCurrency) (*GetCurrencyResponse, error) {
	response := new(GetCurrencyResponse)
	err := service.client.Call("getCurrency", request, response)
	if err != nil {
		return nil, err
	}

	return response, nil
}
